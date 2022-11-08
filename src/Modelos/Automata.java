package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Jesus Lagunes
 */
public class Automata {

    public ArrayList<Nodo> nodosA;
    public ArrayList<Transicion> transicionesA;
    public Alfabeto alfabeto;
    public ArrayList<String> pila;

    public Automata() {
    }

    public Automata(ArrayList<Nodo> nodosA, ArrayList<Transicion> transicionesA, Alfabeto alfabeto, ArrayList<String> pila) {
        this.nodosA = nodosA;
        this.transicionesA = transicionesA;
        this.alfabeto = alfabeto;
        this.pila = pila;
        this.pila.add("Z");
    }

    public boolean recorrerAutomata(String cadena) {
        boolean success = true;
        ArrayList<Nodo> nodosIniciales = new ArrayList();
        
        this.nodosA.forEach((n) -> {
            if(n.isNodoInicio()) {
                nodosIniciales.add(n);
            }
        });
        
        String[] recorrer = cadena.split("");
        int current = 0;
        
        
//        for(int n = 0; n < nodosIniciales.size(); n++){
//            for(int t = 0; t < nodosIniciales.get(n).transicionesOut.size(); t++){
//                if(nodosIniciales.get(n).transicionesOut.get(t).read == recorrer[current]){
//                    current = current +1;
//                    
//                    String toPush = nodosIniciales.get(n).transicionesOut.get(t).push;
//                    if(toPush.length() > 0){
//                        this.pila.add(toPush);
//                    }
//                    
//                    if()
//                    
//                    if(this.pila.get(this.pila.size() - 1) == nodosIniciales.get(n).transicionesOut.get(t).pop) {
//                        this.pila.remove(this.pila.size() - 1);
//                    }
//                } else if (nodosIniciales.get(n).transicionesOut.get(t).read == "") {
//                    
//                }
//            }
//        }
        
        
        return success;
    }

    //SETTERS
    public void setNodosA(ArrayList<Nodo> nodosA) {
        this.nodosA = nodosA;
    }

    public void setTransicionesA(ArrayList<Transicion> transicionesA) {
        this.transicionesA = transicionesA;
    }

    public void setAlfabeto(Alfabeto alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setPila(ArrayList<String> pila) {
        this.pila = pila;
    }

    //GETTERS
    public ArrayList<Nodo> getNodosA() {
        return nodosA;
    }

    public ArrayList<Transicion> getTransicionesA() {
        return transicionesA;
    }

    public Alfabeto getAlfabeto() {
        return alfabeto;
    }

    public ArrayList<String> getPila() {
        return pila;
    }

}
