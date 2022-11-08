package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Jesús Andrés Lagunes Hernández
 */
public class Transicion {
    public Nodo nodoFrom;
    public Nodo nodoTo;
    
    public String read;
    public String pop;
    public String push;

    public Transicion() {
    }
    
    

    public Transicion(Nodo nodoFrom, Nodo nodoTo, String read, String pop, String push) {
        this.nodoFrom = nodoFrom;
        this.nodoTo = nodoTo;
        this.read = read;
        this.pop = pop;
        this.push = push;
    }

    
    
    
    
    
    
    
    
    //SETTERS
    
    public void setNodoFrom(Nodo nodoFrom) {
        this.nodoFrom = nodoFrom;
    }

    public void setNodoTo(Nodo nodoTo) {
        this.nodoTo = nodoTo;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public void setPush(String push) {
        this.push = push;
    }
    
    
    //GETERS

    public Nodo getNodoFrom() {
        return nodoFrom;
    }

    public Nodo getNodoTo() {
        return nodoTo;
    }

    public String getRead() {
        return read;
    }

    public String getPop() {
        return pop;
    }

    public String getPush() {
        return push;
    }

    @Override
    public String toString() {
        return "Transicion{" + "nodoFrom= q" + nodoFrom.idNodo + ", nodoTo= q" + nodoTo.idNodo + ", read=" + read + ", pop=" + pop + ", push=" + push + '}';
    }
    
    
}
