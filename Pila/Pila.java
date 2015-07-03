/*
 * 
 * Estructuras de datos
 *
 * Creado por Ricardo Rodriguez <ricardo96r@gmail.com>
 */

package estructuras;

import ListaSimple;

/**
 *
 * @author Ricardo
 */
public class Pila extends ListaSimple {
    public void push (NodoSimple nuevo) {
        insertaPrimero(nuevo);
    }
    
    public NodoSimple pop() {
        return eliminarPrimero();
    }
    
    public NodoSimple peek() {
        return getCabeza();
    }
}
