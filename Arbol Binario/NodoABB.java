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
public class NodoABB {
    private NodoABB hijoIzquierdo;
    private NodoABB hijoDerecho;
    private int datoEntero;
    private String datoTexto;

    public NodoABB(int datoEntero, String datoTexto) {
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.datoEntero = datoEntero;
        this.datoTexto = datoTexto;
    }

    public NodoABB getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoABB hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoABB getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoABB hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public int getDatoEntero() {
        return datoEntero;
    }

    public void setDatoEntero(int DatoEntero) {
        this.datoEntero = DatoEntero;
    }

    public String getDatoTexto() {
        return datoTexto;
    }

    public void setDatoTexto(String DatoTexto) {
        this.datoTexto = DatoTexto;
    }
    
    public void mostrar() {
        System.out.println("El dato entero es: "+ datoEntero+ " El dato textual es: "+ datoTexto);
    }
    
    public boolean esHoja() {
        return hijoIzquierdo==null&&hijoDerecho==null;
    }
    
    
}
