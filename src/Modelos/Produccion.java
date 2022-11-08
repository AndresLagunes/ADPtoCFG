package Modelos;
/**
 * @author Jesus Lagunes
 */
public class Produccion {
    public String parteIzq;
    public String parteDer;

    public Produccion() {
    }

    public Produccion(String parteIzq, String parteDer) {
        this.parteIzq = parteIzq;
        this.parteDer = parteDer;
    }
    
    
    
    
    //SETTERS
    public void setParteIzq(String parteIzq) {
        this.parteIzq = parteIzq;
    }

    public void setParteDer(String parteDer) {
        this.parteDer = parteDer;
    }
    
    //GETTERS
    public String getParteIzq() {
        return parteIzq;
    }

    public String getParteDer() {
        return parteDer;
    }
    
}
