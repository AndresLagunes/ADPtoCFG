package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Jesús Andrés Lagunes Hernández
 */
public class Nodo {
    public int idNodo;
    public ArrayList<Nodo> nodosOut;
    public ArrayList<Nodo> nodosIn;
    public boolean nodoInicio;
    public boolean nodoAceptacion;

    public Nodo() {
    }
    
    

    public Nodo(int idNodo, ArrayList<Nodo> nodosOut, ArrayList<Nodo> nodosIn, boolean nodoInicio, boolean nodoAceptacion) {
        this.idNodo = idNodo;
        this.nodosOut = nodosOut;
        this.nodosIn = nodosIn;
        this.nodoInicio = nodoInicio;
        this.nodoAceptacion = nodoAceptacion;
    }
    
    
    //SETERS
    
    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }

    public void setNodosOut(ArrayList<Nodo> nodosOut) {
        this.nodosOut = nodosOut;
    }

    public void setNodosIn(ArrayList<Nodo> nodosIn) {
        this.nodosIn = nodosIn;
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

    public ArrayList<Nodo> getNodosOut() {
        return nodosOut;
    }

    public ArrayList<Nodo> getNodosIn() {
        return nodosIn;
    }

    public boolean isNodoInicio() {
        return nodoInicio;
    }

    public boolean isNodoAceptacion() {
        return nodoAceptacion;
    }
    
    
}
