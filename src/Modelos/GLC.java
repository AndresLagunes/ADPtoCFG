package Modelos;

import java.util.ArrayList;

/**
 * @author Jesus Lagunes
 */
public class GLC {
   public ArrayList<String> terminales;
   public ArrayList<String> noTerminales; 
   public ArrayList<Produccion> producciones;

    public GLC() {
    }

    public GLC(ArrayList<String> terminales, ArrayList<String> noTerminales, ArrayList<Produccion> producciones) {
        this.terminales = terminales;
        this.noTerminales = noTerminales;
        this.producciones = producciones;
    }
   
   //SETTERS

    public void setTerminales(ArrayList<String> terminales) {
        this.terminales = terminales;
    }

    public void setNoTerminales(ArrayList<String> noTerminales) {
        this.noTerminales = noTerminales;
    }

    public void setProducciones(ArrayList<Produccion> producciones) {
        this.producciones = producciones;
    }
    
    //GETTERS

    public ArrayList<String> getTerminales() {
        return terminales;
    }

    public ArrayList<String> getNoTerminales() {
        return noTerminales;
    }

    public ArrayList<Produccion> getProducciones() {
        return producciones;
    }
    
}
