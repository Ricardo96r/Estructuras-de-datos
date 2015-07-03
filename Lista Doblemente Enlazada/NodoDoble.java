/*
 * 
 * Estructuras de datos
 *
 * Creado por Ricardo Rodriguez <ricardo96r@gmail.com>
 */

package estructuras;

/**
 *  Nodo doble: tiene 2 apuntadores
 * 
 * @author Ricardo
 */
public class NodoDoble {
    
    private String datoTexto;
    private int datoEntero;
    private NodoDoble proximo;
    private NodoDoble anterior;
    
    public NodoDoble(){
        
    }
    
    public NodoDoble(String datoTexto,int datoEntero){
        this.datoTexto=datoTexto;
        this.datoEntero=datoEntero;
        proximo=null;
        anterior=null;
    }

    public String getDatoTexto() {
        return datoTexto;
    }

    public void setDatoTexto(String datoTexto) {
        this.datoTexto = datoTexto;
    }

    public int getDatoEntero() {
        return datoEntero;
    }

    public void setDatoEntero(int datoEntero) {
        this.datoEntero = datoEntero;
    }

    public NodoDoble getProximo() {
        return proximo;
    }

    public void setProximo(NodoDoble proximo) {
        this.proximo = proximo;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
    public void mostrar(){
        System.out.println("{Texto: "+datoTexto+", Entero:"+datoEntero+"}");
    }
    
}
