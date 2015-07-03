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
public class Cola extends ListaSimple {
    public void encolar(NodoSimple nuevo) {
        insertarFinal(nuevo);
    }
    
    public NodoSimple desencolar() {
        return eliminarPrimero();
    }
    
    public NodoSimple primeroCola() {
        return getCabeza();
    }
}
