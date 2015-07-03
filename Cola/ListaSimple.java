/*
 * 
 * Estructuras de datos
 *
 * Creado por Ricardo Rodriguez <ricardo96r@gmail.com>
 */

package estructuras;

import NodoSimple;

/**
 *
 * @author Ricardo
 */
public class ListaSimple {
    private NodoSimple cabeza;
    
    public ListaSimple() {
        this.cabeza = null;
    }
    
    public ListaSimple(NodoSimple cabeza) {
        this.cabeza = cabeza;
    }
    
    public boolean estaVacio() {
        return cabeza == null;
    }
    
    public NodoSimple getCabeza() {
        return cabeza;
    }
    
    public void mostrar() {
        NodoSimple aux = cabeza;
        while (aux != null) {
            aux.mostrar();
            aux = aux.getProximo();
        }
    }
    
    public void insertarFinal(NodoSimple nuevo) {
        NodoSimple aux = cabeza;
        if (estaVacio()) {
            cabeza = nuevo;
        } else {
            while(aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.setProximo(nuevo);
        }
    }
    
    public NodoSimple eliminarPrimero() {
        NodoSimple nodoEliminado = null;
        if (!estaVacio()) {
                nodoEliminado = cabeza;
                cabeza = cabeza.getProximo();
                nodoEliminado.setProximo(null);
            }
        return nodoEliminado;
    }
    
    public void insertaPrimero(NodoSimple nuevo) {
        if (estaVacio()) {
            cabeza = nuevo;
        } else {
            nuevo.setProximo(cabeza);
            cabeza = nuevo;
        }
    }
    
    public NodoSimple eliminarFinal() {
        NodoSimple aux = cabeza;
        NodoSimple nodoEliminado = null;
        if (!estaVacio()) {
            if (cabeza.getProximo() == null) {
                nodoEliminado = cabeza;
                cabeza = null;
            } else {
                while (aux.getProximo() != null) {
                    aux = aux.getProximo();
                }
                nodoEliminado = aux.getProximo();
                aux.setProximo(null);
            }
        }
        return nodoEliminado; 
    }
    
    public void insertarPosicion(NodoSimple nuevo, int posicion) {
        NodoSimple aux = cabeza;
        int contador = 0;
        if (estaVacio()) {
            cabeza = nuevo;
        } else {
            if (posicion > contar()) {
                System.out.println("Error no existe esta posicion");
            } else if (posicion == 0) {
                insertaPrimero(nuevo);
            } else if (posicion == contar()) {
                insertarFinal(nuevo);
            } else if (posicion < contar()) {
                while (contador < posicion-1) {
                    aux = aux.getProximo();
                    contador++;
                }
                nuevo.setProximo(aux.getProximo());
                aux.setProximo(nuevo);
            }
        }
    }
    
    public void eliminarPosicion(NodoSimple nuevo, int posicion) {
        NodoSimple aux = cabeza;
        int contador = 0;
        if (!estaVacio()) {
            if (posicion > contar()) {
                System.out.println("Error ");
            } else if(posicion == 0) {
                insertaPrimero(nuevo);
            } else if (posicion == contar()) {
                insertarFinal(nuevo);
            } else if (posicion < contar()) {
                while (contador < posicion-1) {
                    aux = aux.getProximo();
                    contador++;
                }
                NodoSimple guardar = aux.getProximo();
                aux.setProximo(guardar.getProximo());
                guardar.setProximo(null);
            }
        }
    }
    
    public int contar() {
        NodoSimple aux = cabeza;
        int contar = 0;
        while (aux != null) {
            contar++;
            aux = aux.getProximo();
        }
        return contar;
    }
    
    
    
}
