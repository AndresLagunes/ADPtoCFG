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
