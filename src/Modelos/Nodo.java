package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Jesús Andrés Lagunes Hernández
 */
public class Nodo {
    public int idNodo;
    public ArrayList<Transicion> transicionesOut;
    public ArrayList<Transicion> transicionesIn;
    public boolean nodoInicio;
    public boolean nodoAceptacion;

    public Nodo() {
    }
    
    

    public Nodo(int idNodo, ArrayList<Transicion> transicionesOut, ArrayList<Transicion> transicionesIn, boolean nodoInicio, boolean nodoAceptacion) {
        this.idNodo = idNodo;
        this.transicionesOut = transicionesOut;
        this.transicionesIn = transicionesIn;
        this.nodoInicio = nodoInicio;
        this.nodoAceptacion = nodoAceptacion;
    }
    
    
    //SETERS
    
    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public void setNodosOut(ArrayList<Transicion> transicionesOut) {
        this.transicionesOut = transicionesOut;
    }

    public void setNodosIn(ArrayList<Transicion> transicionesIn) {
        this.transicionesIn = transicionesIn;
    }

    public void setNodoInicio(boolean nodoInicio) {
        this.nodoInicio = nodoInicio;
    }

    public void setNodoAceptacion(boolean nodoAceptacion) {
        this.nodoAceptacion = nodoAceptacion;
    }
    
    
    //GETERS

    public int getIdNodo() {
        return idNodo;
    }

    public ArrayList<Transicion> getNodosOut() {
        return transicionesOut;
    }

    public ArrayList<Transicion> getNodosIn() {
        return transicionesIn;
    }

    public boolean isNodoInicio() {
        return nodoInicio;
    }

    public boolean isNodoAceptacion() {
        return nodoAceptacion;
    }
    
    
}
