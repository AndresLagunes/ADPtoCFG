
import Modelos.*;
import java.util.ArrayList;

/**
 *
 * @author Jesús Andrés Lagunes Hernández
 */
public class ADPToCFG {
    public static Automata automata = new Automata(
            new ArrayList(),//nodos
            new ArrayList(),//transiciones
            new Alfabeto(new ArrayList()),//alfabeto
            new ArrayList()//pila
    );
    
    public static GLC gramatica = new GLC(
            new ArrayList(),
            new ArrayList(),
            new ArrayList()
    );
    
    public static void main(String[] args) {
        automata.alfabeto.alfabeto.add(0,"0");
        automata.alfabeto.alfabeto.add(1,"1");
        
        String cadena = "0011";
        add2();
        
        prepararAutomata(automata);
        gramatica = convertirAutomata(automata);
        
        
        
//        automata.recorrerAutomata(cadena);
    }
    
    static GLC convertirAutomata(Automata a){
        GLC gramatica = new GLC(new ArrayList(), new ArrayList(), new ArrayList());
        //producciones de tipo 1, que corresponden a transiciones
        //que llevan de un nodo, al mismo nodo con épsilon
        ArrayList<Produccion> type1 = new ArrayList();
        a.nodosA.forEach((n) -> {
            type1.add(new Produccion("Aq"+n.idNodo+",q"+n.idNodo, ""));
        });
        gramatica.producciones.addAll(type1);
        System.out.println("reglas totales tipo 1"+type1.size());
        //producciones de tipo 2, son producciones que llevan de un nodo a otro
        //pasando por otro nodo
        ArrayList<Produccion> type2 = new ArrayList();
        a.nodosA.forEach((n1) -> {
            a.nodosA.forEach((n2) -> {
               a.nodosA.forEach((n3) -> {
                   type2.add(new Produccion("Aq"+n1.idNodo+",q"+n2.idNodo, "Aq"+n1.idNodo+",q"+n3.idNodo + "Aq"+n3.idNodo+",q"+n2.idNodo));
                }); 
            });
        });
        gramatica.producciones.addAll(type2);
        System.out.println("reglas totales tipo 2"+type2.size());
        
        //producciones de tipo 3, corresponden a un par de transiciones en donde una hace push
        //de un caracter y la otra hace pop de ese mismo caracter
        ArrayList<Produccion> type3 = new ArrayList();
        a.transicionesA.forEach((t1) -> {
            a.transicionesA.forEach((t2) -> {
                if(t1.push == t2.pop){
                    type3.add(new Produccion("Aq"+t1.nodoFrom.idNodo+",q"+t2.nodoTo.idNodo, t1.read+ "Aq"+t1.nodoTo.idNodo+",q"+t2.nodoFrom.idNodo + t2.read));
                }
            });
        });
        gramatica.producciones.addAll(type3);
        System.out.println("reglas totales tipo 3"+type3.size());
        return gramatica;
    }
    
    static void prepararAutomata(Automata a){
        a.transicionesA.forEach((t) -> {
            System.out.println(t.toString());
        });
        System.out.println("nodos iniciales: "+a.nodosA.size());
        System.out.println("transiciones iniciales: "+ a.transicionesA.size());
        //Agregar un nodo donde se poppee todo lo que quede en la pila si es necesario
        //Todos los nodos finales apuntarán a este nodo y dejarán de ser finales
        Nodo popAll = new Nodo(
                a.nodosA.size() - 1,
                false,              //si es nodo iniciar
                false);             //si es nodo de aceptación
        
        a.nodosA.add(popAll);
        ArrayList<String> already = new ArrayList();
        
        ArrayList<Transicion> tToAdd = new ArrayList();
        a.transicionesA.forEach((t) -> {
            if(!already.contains(t.push) && t.push.length() > 0){
                already.add(t.push);
                tToAdd.add(new Transicion(popAll, popAll, "", t.push, ""));
            }
        });
        System.out.println(already.toString());
        tToAdd.forEach((t) ->{
            a.transicionesA.add(t);
        });
        //nuevo nodo inicial, los automatas tienen que tener un único nodo inicial
        Nodo initial = new Nodo(
                a.nodosA.size() - 1,
                true,              //si es nodo iniciar
                false);            //si es nodo de aceptación
        Nodo fin = new Nodo(
                a.nodosA.size() - 1,
                false,              //si es nodo iniciar
                true);            //si es nodo de aceptación
        a.transicionesA.add(new Transicion(popAll, fin, "", "$", ""));
        
        a.nodosA.forEach((n) -> {
            if(n.nodoAceptacion){
                Transicion toPopAll = new Transicion(n,popAll,"","","");
                a.transicionesA.add(toPopAll);
                n.nodoAceptacion = false;
            }
            if(n.nodoInicio){
                Transicion startNode = new Transicion(initial,n,"","","$");
                a.transicionesA.add(startNode);
                n.nodoInicio = false;
            }
        });
        a.nodosA.add(initial);
        a.nodosA.add(fin);
        
        //convierte las transiciones que triple epsilon en transiciones que hacen
        //un pop o push mínimo
        //convierte las transciones que hagan push y pop a la vez en dos transiciones
        //con un nodo auxiliar para que solo hagan una cosa a la vez
        tToAdd.clear();
        ArrayList<Transicion> tToRem = new ArrayList();
        a.transicionesA.forEach((t) -> {            
            if(t.pop.length() == 0 && t.push.length() == 0){
                Nodo aux = new Nodo(
                a.nodosA.size() - 1,
                false,              //si es nodo iniciar
                false);            //si es nodo de aceptación
                a.nodosA.add(aux);
                Transicion in = new Transicion(t.nodoFrom,aux,"", "", "0");
                Transicion out = new Transicion(aux,t.nodoTo,"","0","");
                tToAdd.add(in);
                tToAdd.add(out);
                tToRem.add(t);
            } else if(t.pop.length() > 0 && t.push.length() > 0){
                Nodo aux = new Nodo(
                a.nodosA.size() - 1,
                false,              //si es nodo iniciar
                false);            //si es nodo de aceptación
                a.nodosA.add(aux);
                Transicion in = new Transicion(t.nodoFrom,aux,t.read, "",t.push);
                Transicion out = new Transicion(aux,t.nodoTo,"",t.pop,"");
                tToAdd.add(in);
                tToAdd.add(out);
                tToRem.remove(t);
            }
        });
        tToAdd.forEach((t) -> {
            a.transicionesA.add(t);
        });
        tToRem.forEach((t) ->{
            a.transicionesA.remove(t);
        });
        
        System.out.println("nodos finales: "+a.nodosA.size());
        System.out.println("transiciones finales: "+ a.transicionesA.size());
    }
    
    static void add1(){
        automata.nodosA.add(
                new Nodo(
                        0,                  //id nodo
                        true,               //si es nodo iniciar
                        false));            ////si es nodo de aceptación
        automata.nodosA.add(
                new Nodo(
                        1,                  //id nodo
                        false,              //si es nodo iniciar
                        false));            ////si es nodo de aceptación
        automata.nodosA.add(
                new Nodo(
                        2,                  //id nodo
                        false,              //si es nodo iniciar
                        true));             //si es nodo de aceptación
        
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(0),       //nodo from  
                        automata.nodosA.get(0),       //nodo to
                        "0",                //caracter a leer
                        "",                 //pop
                        "0"));              //push
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(0),       //nodo from  
                        automata.nodosA.get(1),       //nodo to
                        "1",                //caracter a leer
                        "0",                 //pop
                        ""));              //push
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(1),       //nodo from  
                        automata.nodosA.get(1),       //nodo to
                        "1",                //caracter a leer
                        "0",                 //pop
                        ""));              //push
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(1),      //nodo from  
                        automata.nodosA.get(2),      //nodo to
                        "",                //caracter a leer
                        "Z",               //pop
                        ""));              //push
    }

    static void add2(){
        automata.nodosA.add(
                new Nodo(
                        0,                  //id nodo
                        true,               //si es nodo iniciar
                        false));            ////si es nodo de aceptación
        automata.nodosA.add(
                new Nodo(
                        1,                  //id nodo
                        false,              //si es nodo iniciar
                        false));            ////si es nodo de aceptación
        automata.nodosA.add(
                new Nodo(
                        2,                  //id nodo
                        false,              //si es nodo iniciar
                        false));            ////si es nodo de aceptación
        automata.nodosA.add(
                new Nodo(
                        3,                  //id nodo
                        false,              //si es nodo iniciar
                        true));             //si es nodo de aceptación
        
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(0),       //nodo from  
                        automata.nodosA.get(1),       //nodo to
                        "",                //caracter a leer
                        "",                 //pop
                        "Z"));              //push
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(1),       //nodo from  
                        automata.nodosA.get(1),       //nodo to
                        "0",                //caracter a leer
                        "",                 //pop
                        "0"));              //push
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(1),       //nodo from  
                        automata.nodosA.get(2),       //nodo to
                        "",                //caracter a leer
                        "",                //pop
                        ""));              //push
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(2),      //nodo from  
                        automata.nodosA.get(2),      //nodo to
                        "1",                //caracter a leer
                        "0",               //pop
                        ""));              //push
        automata.transicionesA.add(
                new Transicion(
                        automata.nodosA.get(2),      //nodo from  
                        automata.nodosA.get(3),      //nodo to
                        "",                //caracter a leer
                        "Z",               //pop
                        ""));              //push
    }
}
