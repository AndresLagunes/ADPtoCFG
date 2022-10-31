
import Modelos.Alfabeto;
import Modelos.Automata;
import Modelos.Nodo;
import Modelos.Transicion;
import java.util.ArrayList;

/**
 *
 * @author Jesús Andrés Lagunes Hernández
 */
public class ADPToCFG {
    public static Automata automata = new Automata(
            new ArrayList(),
            new ArrayList(),
            new Alfabeto(),
            new ArrayList()
    );
    
    public static void main(String[] args) {
        automata.alfabeto.alfabeto.add(0,"0");
        automata.alfabeto.alfabeto.add(1,"1");
        
        String cadena = "0011";
        
        automata.nodosA.add(
                new Nodo(
                        0,                  //id nodo
                        new ArrayList(),    //arraylist de transiciones que entran
                        new ArrayList(),    //arraylist de transiciones que salen
                        true,               //si es nodo iniciar
                        false));            ////si es nodo de aceptación
        automata.nodosA.add(
                new Nodo(
                        1,                  //id nodo
                        new ArrayList(),    //arraylist de transiciones que entran
                        new ArrayList(),    //arraylist de transiciones que salen
                        false,              //si es nodo iniciar
                        false));            ////si es nodo de aceptación
        automata.nodosA.add(
                new Nodo(
                        2,                  //id nodo
                        new ArrayList(),    //arraylist de transiciones que entran
                        new ArrayList(),    //arraylist de transiciones que salen
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
        
        
        //Programa prueba:
        for(int i = 0; i < cadena.length(); i++){
            
        }
    }
    
}
