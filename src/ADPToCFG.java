
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
    
    public static void main(String[] args) {
        automata.alfabeto.alfabeto.add(0,"0");
        automata.alfabeto.alfabeto.add(1,"1");
        
        String cadena = "0011";
        add2();
        
        prepararAutomata(automata);
        convertirAutomata(automata);
        
        
        
//        automata.recorrerAutomata(cadena);
    }
    
    static void convertirAutomata(Automata a){
        GLC gramatica = new GLC(new ArrayList(), new ArrayList(), new ArrayList());
//        gramatica.producciones()
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
