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
public class ArbolBinarioBusqueda {
    private NodoABB raiz;
    
    public ArbolBinarioBusqueda(NodoABB raiz) {
        this.raiz = raiz;
    }
    
    public boolean estaVacio() {
        return raiz == null;
    }
    
    public void mostrarPreOrden(NodoABB aux) {
        while(aux != null) {
            aux.mostrar();
            mostrarPreOrden(aux.getHijoIzquierdo());
            mostrarPreOrden(aux.getHijoDerecho());
        }
    }
    
    public void mostrarEnOrden(NodoABB aux) {
        while (aux != null) {
            mostrarEnOrden(aux.getHijoIzquierdo());
            aux.mostrar();
            mostrarEnOrden(aux.getHijoDerecho());
        }
    }
    
    public void mostrarPostOrden(NodoABB aux) {
        while (aux != null) {
            mostrarEnOrden(aux.getHijoIzquierdo());
            mostrarEnOrden(aux.getHijoDerecho());
            aux.mostrar();
        }
    }
    
    public void insertar(NodoABB aux, NodoABB nuevo) {
        if (estaVacio()) {
            raiz = nuevo;
        } else {
            if (nuevo.getDatoEntero() < aux.getDatoEntero()) {
                if (aux.getHijoIzquierdo() != null) {
                    insertar(aux.getHijoIzquierdo(), nuevo);
                } else {
                    aux.setHijoIzquierdo(nuevo);
                }
            } else if (nuevo.getDatoEntero() > aux.getDatoEntero()) {
                if (aux.getHijoDerecho() != null) {
                    insertar(aux.getHijoDerecho(), nuevo);
                } else {
                    aux.setHijoDerecho(nuevo);
                }
            } else if (nuevo.getDatoEntero() == aux.getDatoEntero()) {
                System.out.println("No se puede insertar ya que existe un nodo con el mismo datoEntero");
            }
        }
    }
    
    public void suprimirHijoIzquierdo(NodoABB aux) {
       if (aux!=null) {
           aux.setHijoIzquierdo(null);
       }
    }
    
    public void suprimirHijoDerecho(NodoABB aux) {
        if (aux!=null) {
            aux.setHijoIzquierdo(null);
        }   
    }
    
    public int contarNodo (NodoABB aux) {
        if (aux == null) {
            return 0;
        } else {
            return 1 + (contarNodo(aux.getHijoIzquierdo()) + contarNodo(aux.getHijoDerecho()));
        }
    }
    
    public int contarHoja (NodoABB aux) {
        if (aux != null) {
            return 0;
        } else {
            return 1 + contarHoja(aux.getHijoIzquierdo()) + contarHoja(aux.getHijoDerecho());
        }
    }
    
    public NodoABB buscar (NodoABB aux, int datoEntero) {
        if (!estaVacio()) {
            if (aux.getDatoEntero() == datoEntero) {
                return aux;
            } else if (aux.getDatoEntero() > datoEntero) {
                buscar(aux.getHijoIzquierdo(), datoEntero);
            } else if (aux.getDatoEntero() < datoEntero) {
                buscar (aux.getHijoDerecho(), datoEntero);
            }
        }
        return null;
    }
    
    public int sumarHojas (NodoABB aux) {
        if (aux != null) {
            return 0;
        } else {
            return aux.getDatoEntero() + sumarHojas(aux.getHijoIzquierdo()) + sumarHojas(aux.getHijoDerecho());
        }
    }
    
    public int sumarNodos (NodoABB aux) {
        if (aux == null) {
            return 0;
        } else {
            return aux.getDatoEntero() + sumarNodos(aux.getHijoIzquierdo()) + sumarNodos(aux.getHijoDerecho());
        }
    }
    
    public int mayor (int a, int b) {
        int dato;
        if (a >= b) {
            dato = a;
        } else {
            dato = b;
        }
        return dato;
    }
    
    public int altura(int altura, NodoABB aux) {
        if (aux!=null) {
            if (aux.getHijoDerecho()!=null && aux.getHijoIzquierdo()!=null) {
                return mayor(altura(++altura, aux.getHijoIzquierdo()),altura(++altura,aux.getHijoDerecho()));
            } else if (aux.getHijoIzquierdo()!=null) {
                return altura(++altura, aux.getHijoIzquierdo());
            } else if (aux.getHijoDerecho()!=null) {
                return altura(++altura, aux.getHijoDerecho());
            }
        }
        return 0;
    }
    
    public boolean esta(NodoABB aux, int datoEntero) {
        if (!estaVacio()) {
            if (aux.getDatoEntero() == datoEntero) {
                return true;
            } else if (aux.getDatoEntero() > datoEntero) {
                buscar(aux.getHijoIzquierdo(), datoEntero);
            } else if (aux.getDatoEntero() < datoEntero) {
                buscar (aux.getHijoDerecho(), datoEntero);
            }
        }
        return false;
    }
    
    public void podarHojas(NodoABB aux) {
        if (aux!=null) {
            if(aux.getHijoDerecho().esHoja()&&aux.getHijoIzquierdo().esHoja()) {
                aux.setHijoDerecho(null);
                aux.setHijoIzquierdo(null);
            } else if (aux.getHijoIzquierdo().esHoja()) {
                aux.setHijoIzquierdo(null);
            } else if (aux.getHijoDerecho().esHoja()) {
                aux.setHijoDerecho(null);
            } else {
                podarHojas(aux.getHijoIzquierdo());
                podarHojas(aux.getHijoDerecho());
            }
        }
    }
    
    public int getNivelNodo(NodoABB aux, int datoEntero, int nivel) {
        if (aux.getDatoEntero()!=datoEntero) {
            if (aux.getHijoDerecho()!=null&&aux.getHijoIzquierdo()!=null) {
                if (datoEntero < aux.getDatoEntero()) {
                    getNivelNodo(aux.getHijoIzquierdo(), datoEntero, ++nivel);
                } else {
                    getNivelNodo(aux.getHijoDerecho(), datoEntero, ++nivel);
                }
            } else if (aux.getHijoDerecho()!=null) {
                aux = aux.getHijoDerecho();
                if (datoEntero < aux.getDatoEntero()) {
                    getNivelNodo(aux.getHijoIzquierdo(), datoEntero, ++nivel);
                } else {
                    getNivelNodo(aux.getHijoDerecho(), datoEntero, ++nivel);
                }
            } else if (aux.getHijoIzquierdo()!=null) {
                aux = aux.getHijoIzquierdo();
                if (datoEntero < aux.getDatoEntero()) {
                    getNivelNodo(aux.getHijoIzquierdo(), datoEntero, ++nivel);
                } else {
                    getNivelNodo(aux.getHijoDerecho(), datoEntero, ++nivel);
                }
            } else {
                return nivel;
            }
        } else {
            return nivel;
        }
        return 0;
    }
}
