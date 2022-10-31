package Modelos;

import java.util.ArrayList;

/**
 *
 * @author Jesús Andrés Lagunes Hernández
 */
public class Alfabeto {
    public ArrayList<String> alfabeto;

    public Alfabeto() {
    }

    public Alfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    //Getter
    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }
    //setter
    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }
   
}
