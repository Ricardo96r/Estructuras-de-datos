/*
 * 
 * Estructuras de datos
 *
 * Creado por Ricardo Rodriguez <ricardo96r@gmail.com>
 */

package estructuras;

/**
 *
 * @author Ricardo
 */
public class NodoSimple {
    private NodoSimple proximo;
    private int datoEntero;
    private String datoString;

    public NodoSimple(int datoEntero, String datoString) {
        this.proximo = null;
        this.datoEntero = datoEntero;
        this.datoString = datoString;
    }

    public NodoSimple getProximo() {
        return proximo;
    }

    public void setProximo(NodoSimple proximo) {
        this.proximo = proximo;
    }

    public int getDatoEntero() {
        return datoEntero;
    }

    public void setDatoEntero(int datoEntero) {
        this.datoEntero = datoEntero;
    }

    public String getDatoString() {
        return datoString;
    }

    public void setDatoString(String datoString) {
        this.datoString = datoString;
    }
    
    public void mostrar() {
        System.out.println("El dato entero es: "+datoEntero+" El dato String es: "+ datoString);
    }
    
}
