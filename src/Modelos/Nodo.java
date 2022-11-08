package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Jesús Andrés Lagunes Hernández
 */
public class Nodo {
    public int idNodo;
    public boolean nodoInicio;
    public boolean nodoAceptacion;

    public Nodo() {
    }
    
    

    public Nodo(int idNodo, boolean nodoInicio, boolean nodoAceptacion) {
        this.idNodo = idNodo;
        this.nodoInicio = nodoInicio;
        this.nodoAceptacion = nodoAceptacion;
    }
    
    
    //SETERS
    
    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
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


    public boolean isNodoInicio() {
        return nodoInicio;
    }

    public boolean isNodoAceptacion() {
        return nodoAceptacion;
    }
    
    
}
