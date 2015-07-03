/*
 * 
 * Estructuras de datos
 *
 * Creado por Ricardo Rodriguez <ricardo96r@gmail.com>
 */

package estructuras;

/**
 * Lista Doble: tiene 2 apuntadores la cola y la cabeza
 * @author Ricardo
 */
public class ListaDoble {

    private NodoDoble cabeza;
    private NodoDoble cola;

    public ListaDoble() {
        this.cabeza = null;
        this.cola=null;
    }
    
    public ListaDoble(NodoDoble cabeza){
        this.cabeza=cabeza;
        this.cola=null;
    }

    public NodoDoble getCabeza() {
        return cabeza;
    }
    
    public NodoDoble getCola(){
        return cola;
    }
    
    public boolean estaVacia() {
        return cabeza == null;
    }

    public void mostrar() {
        NodoDoble aux = cabeza;
        while (aux != null) {
            aux.mostrar();
            aux = aux.getProximo();
        }
    }
    
    public void mostrarInversa(){
        NodoDoble aux2 = cola;
        while (aux2 != null) {
            aux2.mostrar();
            aux2 = aux2.getAnterior();
        }
    }

    public void insertarPrimero(NodoDoble nuevo) {
        if (estaVacia()) {
            cabeza = cola = nuevo;
        } else {
            if(cabeza==cola){
                nuevo.setProximo(cabeza);
                cola = cabeza;
                cabeza = nuevo;
                cola.setAnterior(cabeza);
            }
            else{
                nuevo.setProximo(cabeza);
                cabeza.setAnterior(nuevo);
                cabeza = nuevo;
            }   
        }
        

    }

    public NodoDoble eliminarPrimero() {
        NodoDoble nodoEliminado=null;
        if (!estaVacia()) {
            if(cabeza==cola){
                nodoEliminado=cabeza;
                cabeza=cola=null;
            }
            else{
                nodoEliminado=cabeza;
                cabeza=cabeza.getProximo();
                cabeza.setAnterior(null);
                nodoEliminado.setProximo(null);
            }
        } 
               
        return nodoEliminado;
    }
    
    public void insertarFinal(NodoDoble nuevo) {
        if (estaVacia()) {
            cabeza = cola = nuevo;
        } else {
            cola.setProximo(nuevo);
            nuevo.setAnterior(cola);
            cola=nuevo;           
        }
    }
    
    public NodoDoble eliminarFinal() {
        NodoDoble nodoEliminado=null;
        if (!estaVacia()){
            if(cabeza==cola){
                nodoEliminado=cabeza;
                cabeza=cola=null;
            }
            else{
                nodoEliminado=cola;
                cola=cola.getAnterior();
                cola.setProximo(null);
                nodoEliminado.setAnterior(null);
            }
        }
        return nodoEliminado;
    }
    
    public void insertarPosicion(NodoDoble nuevo, int posicion){
        if(estaVacia())
            cabeza=cola=nuevo;
        else{
            if (posicion>contar()+1) 
                System.out.println("-ERROR: No existe la posicion");
            else if (posicion == 1)
                insertarPrimero(nuevo);
            else if (posicion == contar()+1)
                insertarFinal(nuevo);
            else
            {
                NodoDoble aux = cabeza;
                int cont = 1;
                while (cont < (posicion - 1))
                {
                    cont++;
                    aux = aux.getProximo();
                }
                nuevo.setProximo(aux.getProximo());
                aux.setProximo(nuevo);
                aux.getProximo().setAnterior(nuevo);
                nuevo.setAnterior(aux);
            }
        }
    }

    
    public NodoDoble eliminarPosicion(int posicion){
        NodoDoble nodoEliminado=null;
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
    		System.out.println("ERROR: posicion no valida");
            }   
            else
            {
    		NodoDoble aux = cabeza;
    		int cont = 1;
    		while(cont < posicion - 1)
    		{
    		    cont++;
                    aux = aux.getProximo();
    		}
    		nodoEliminado = aux.getProximo();
    		aux.setProximo(nodoEliminado.getProximo());
                nodoEliminado.getProximo().setAnterior(aux);
    		nodoEliminado.setProximo(null);	
                nodoEliminado.setAnterior(null);	
            }
        }
        return nodoEliminado;
    }
    
    public int contar(){
        NodoDoble aux=cabeza;
        int cont=0;
        while(aux!=null){
            aux=aux.getProximo();
            cont++;
        }
        return cont;
    }
  
}
