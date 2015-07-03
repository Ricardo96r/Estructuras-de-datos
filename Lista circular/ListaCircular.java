/*
 * 
 * Estructuras de datos
 *
 * Creado por Ricardo Rodriguez <ricardo96r@gmail.com>
 */

package estructuras;

/**
 * Lista circular: la cabeza apunta a la cola
 * @author Ricardo
 */
public class ListaCircular {

    private NodoSimple cabeza;

    public ListaCircular() {
        this.cabeza = null;
    }
    
    public ListaCircular(NodoSimple cabeza){
        this.cabeza=cabeza;
    }

    public NodoSimple getCabeza() {
        return this.cabeza;
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }

    public void mostrar() {
        NodoSimple aux = cabeza;
        while (aux.getProximo() != cabeza) {
            aux.mostrar();
            aux = aux.getProximo();
        }
        aux.mostrar();
    }

    public void insertarPrimero(NodoSimple nuevo) {
        if (estaVacia()) {
            cabeza = nuevo;
            cabeza.setProximo(cabeza);
        } else {
            nuevo.setProximo(cabeza);
            NodoSimple aux=cabeza;
            while(aux.getProximo()!=cabeza){
                aux=aux.getProximo();
            }
            aux.setProximo(nuevo);
            cabeza = nuevo;
        }
    }

    
    public NodoSimple eliminarPrimero() {
        NodoSimple nodoEliminado=null;
        if (!estaVacia()) {
            if(cabeza==cabeza.getProximo()){
                nodoEliminado=cabeza;
                cabeza=null;
            }
            else{
                NodoSimple aux=cabeza;
                nodoEliminado=cabeza;
                while(aux.getProximo()!=cabeza){
                    aux=aux.getProximo();
                }
                aux.setProximo(nodoEliminado.getProximo());
                cabeza=nodoEliminado.getProximo();
                nodoEliminado.setProximo(null);
            }
        } 
        return nodoEliminado;
    }

    public void insertarFinal(NodoSimple nuevo) {
        if (estaVacia()) {
            cabeza = nuevo;
            cabeza.setProximo(cabeza);
        } else {
            NodoSimple aux=cabeza;
            while(aux.getProximo()!=cabeza){
                aux=aux.getProximo();
            }
            aux.setProximo(nuevo);
            nuevo.setProximo(cabeza);
        }
    }
    
    public NodoSimple eliminarFinal() {
        NodoSimple nodoEliminado=null;
        if (!estaVacia()){
            if(cabeza.getProximo()==cabeza){
                nodoEliminado=cabeza;
                cabeza=null;
            }
            else{
                NodoSimple aux=cabeza;
                
                while(aux.getProximo().getProximo()!=cabeza){
                    aux=aux.getProximo();
                }
                nodoEliminado=aux.getProximo();
                aux.setProximo(cabeza);
                nodoEliminado.setProximo(null);
            }
        }
        return nodoEliminado;
    }
    
    public void insertarPosicion(NodoSimple nuevo, int posicion){
        if(estaVacia())
            cabeza=nuevo;
        else{
            if (posicion>contar()+1) 
                System.out.println("No existe la posicion, imposible insertar el nodo");
            else if (posicion == 1)
                insertarPrimero(nuevo);
            else if (posicion == contar()+1)
                insertarFinal(nuevo);
            else
            {
                NodoSimple aux = cabeza;
                int cont = 1;
                while (cont < (posicion - 1))
                {
                    cont++;
                    aux = aux.getProximo();
                }
                nuevo.setProximo(aux.getProximo());
                aux.setProximo(nuevo);
            }
        }
    }

    public NodoSimple eliminarPosicion(int posicion){
        NodoSimple nodoEliminado=null;
        if(!estaVacia())
        {
            if(posicion == 1)
            {
    		nodoEliminado=eliminarPrimero();
            }
            else if(posicion == contar())
            {
    		nodoEliminado=eliminarFinal();
            }
            else if(posicion > contar() + 1)
            {
    		System.out.println("Error: posicion nula");
            }   
            else
            {
    		NodoSimple aux = cabeza;
    		int cont = 1;
    		while(cont < posicion - 1)
    		{
    		    cont++;
                    aux = aux.getProximo();
    		}
    		nodoEliminado = aux.getProximo();
    		aux.setProximo(nodoEliminado.getProximo());
    		nodoEliminado.setProximo(null);		
            }
        }
        return nodoEliminado;
    }
    
    public int contar(){
        NodoSimple aux=cabeza;
        int cont=0;
        while(aux!=cabeza||cont==0){
            aux=aux.getProximo();
            cont++;
        }
        return cont;
    }
  
}
