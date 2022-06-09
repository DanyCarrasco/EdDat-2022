/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *
 * @author casa
 */
public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        /*Inserta elemenNuevo como hijo del primer nodo encontrado en precorden igual
        a elemPadre, como el hijo izquierdo (I) o derecho (D), segun lo indique el
        parametro lugar*/
        boolean exito = true;
        if (this.raiz == null) {
            //Si el arbol esta vacio, pone elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            //Si arbol no esta vacio, busca al padre
            NodoArbol nPadre = obtenerNodo(this.raiz, elemPadre);

            //Si padre existe y lugar no esta ocupado lo pone, sino da error
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzquierdo() == null) {
                    nPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else {
                    if (lugar == 'D' && nPadre.getDerecho() == null) {
                        nPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } else {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        //metodo PRIVADO que busca un elemento y devuelve el nodo que 
        //lo contiene. Si no se encuentra retorna null
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //Si el buscado es n, lo devuelve 
                resultado = n;
            } else {
                //no es el buscado; busca primero en el hijo HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encuentra en el HI, busca en HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        // Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en caso contrario.
        return this.raiz == null;
    }

    public int altura() {
        int altura = -1;
        if (!esVacio()) {
            altura = alturaAux(this.raiz);
        }
        return altura;
    }

    private int alturaAux(NodoArbol n) {
        int altura = 0;
        int contador1, contador2;
        if (n != null) {
            if (!(n.getIzquierdo() == null && n.getDerecho() == null)) {
                altura = altura + 1;
                contador1 = alturaAux(n.getIzquierdo());
                contador2 = alturaAux(n.getDerecho());
                if (contador1 >= contador2) {
                    altura = altura + contador1;
                } else {
                    altura = altura + contador2;
                }
            }
        }
        return altura;
    }

    public int nivel(Object elemento) {
        int res = 0;
        if (this.raiz == null) {
            res = - 1;
        } else {
            res = nivelAux(this.raiz, elemento);
        }
        return res;
    }

    private int nivelAux(NodoArbol n, Object elem) {
        int res = - 1;
        int aux = - 1;
        if (n != null) {
            if (n.getElem() == elem) {
                res = 0;
            } else {
                aux = nivelAux(n.getIzquierdo(), elem) + 1;
                if (aux == 0) {
                    aux = nivelAux(n.getDerecho(), elem) + 1;
                }
                if (aux == 0) {
                    res = - 1;
                } else {
                    res = aux;
                }
            }
        }
        return res;
    }

    public Object padre(Object elemento) {
        Object padre = null;
        if (!esVacio()) {
            if (!this.raiz.getElem().equals(elemento)) {
                padre = padreAux(this.raiz, elemento);
            }
        }
        return padre;
    }

    private Object padreAux(NodoArbol n, Object elem) {
        Object padre = null;
        if (n != null) {
            if (n.getIzquierdo() != null && n.getIzquierdo().getElem().equals(elem)) {
                padre = n.getElem();
            } else {
                if (padre == null && n.getDerecho() != null && n.getDerecho().getElem().equals(elem)) {
                    padre = n.getElem();
                }
            }
            if (padre == null) {
                padre = padreAux(n.getIzquierdo(), elem);
            }
            if (padre == null) {
                padre = padreAux(n.getDerecho(), elem);
            }
        }
        return padre;
    }

    public Lista listarPreorden() {
        // retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        // metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); //(1)

            // recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis);    //(2)
            listarPreordenAux(nodo.getDerecho(), lis);      //(3)
        }
    }

    public Lista listarInorden() {
        // retorna una lista con los elementos del arbol en INORDEN
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        // metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            // recorre a sus hijos en inorden
            // recorre a su hijo izquierdo
            listarInordenAux(nodo.getIzquierdo(), lis);     //(1)

            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); //(2)

            // visita a su hijo derecho
            listarInordenAux(nodo.getDerecho(), lis);       //(3)
        }
    }

    public Lista listarPosorden() {
        // retorna una lista con los elementos del arbol en POSORDEN
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        // metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            // recorre a sus hijos en posorden
            listarPosordenAux(nodo.getIzquierdo(), lis);   //(1)
            listarPosordenAux(nodo.getDerecho(), lis);     //(2)

            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); //(3)
        }
    }

    public Lista listarPorNiveles() {
        Lista lis = new Lista();
        listarPorNivelesAux(this.raiz, lis);
        return lis;
    }

    private void listarPorNivelesAux(NodoArbol n, Lista lis) {
        Cola Q = new Cola();
        NodoArbol nodoActual;
        Q.poner(n);
        while (!Q.esVacia()) {
            nodoActual = (NodoArbol) Q.obtenerFrente();
            Q.sacar();
            if (nodoActual != null) {
                lis.insertar(nodoActual.getElem(), lis.longitud() + 1);
                if (nodoActual.getIzquierdo() != null) {
                    Q.poner(nodoActual.getIzquierdo());
                }
                if (nodoActual.getDerecho() != null) {
                    Q.poner(nodoActual.getDerecho());
                }
            }
        }
    }

    public ArbolBin clone() {
        //Genera y devuelve una cadena de caracteres que indica cuál es la raíz 
        //del árbol y quienes son los hijos de cada nodo.
        ArbolBin clon = new ArbolBin();
        if (!esVacio()) {
            clon.raiz = cloneAux(this.raiz);
        }
        return clon;
    }

    private NodoArbol cloneAux(NodoArbol n) {
        NodoArbol nuevo = new NodoArbol(n.getElem(), null, null);
        if (n.getIzquierdo() != null) {
            nuevo.setIzquierdo(cloneAux(n.getIzquierdo()));
        }
        if (n.getDerecho() != null) {
            nuevo.setDerecho(cloneAux(n.getDerecho()));
        }
        return nuevo;
    }

    public void vaciar() {
        //Quita todos los elementos de la estructura. 
        //El manejo de memoria es similar al explicado anteriormente para estructuras lineales dinámicas.
        this.raiz = null;
    }

    public String toString() {
        String cadena = "Lista vacia";
        if (!esVacio()) {
            cadena = stringAux(this.raiz, "");
        }
        return cadena;
    }

    private String stringAux(NodoArbol nodo, String cadena) {
        if (nodo != null) {
            cadena = cadena + "Elemento: " + nodo.getElem();
            if (nodo.getIzquierdo() != null) {
                cadena = cadena + " HI: " + nodo.getIzquierdo().getElem() + " ";
            } else {
                cadena = cadena + " HI: - ";
            }
            if (nodo.getDerecho() != null) {
                cadena = cadena + " HD: " + nodo.getDerecho().getElem() + " \n";
            } else {
                cadena = cadena + " HD: - \n";
            }
            cadena = stringAux(nodo.getIzquierdo(), cadena);
            cadena = stringAux(nodo.getDerecho(), cadena);
        }
        return cadena;
    }

    public Lista frontera() {
        Lista lis = new Lista();
        if (!esVacio()) {
            fronteraAux(this.raiz, lis);
        }
        return lis;
    }

    private void fronteraAux(NodoArbol n, Lista lis) {
        if (n != null) {
            if (n.getIzquierdo() == null && n.getDerecho() == null) {
                lis.insertar(n.getElem(), lis.longitud() + 1);
            }
            fronteraAux(n.getIzquierdo(), lis);
            fronteraAux(n.getDerecho(), lis);
        }
    }

    public Lista obtenerAncestros(Object elem) {
        Lista lis = new Lista();
        if (!esVacio()) {
            buscarAncestros(this.raiz, lis, elem);
        }
        return lis;
    }

    private boolean buscarAncestros(NodoArbol n, Lista lis, Object elem) {
        boolean encontrado = false;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                encontrado = true;
            } else {
                encontrado = buscarAncestros(n.getIzquierdo(), lis, elem);
                if (encontrado) {
                    lis.insertar(n.getElem(), lis.longitud() + 1);
                } else {
                    encontrado = buscarAncestros(n.getDerecho(), lis, elem);
                    if (encontrado) {
                        lis.insertar(n.getElem(), lis.longitud() + 1);
                    }
                }
            }
        }
        return encontrado;
    }

    /*public Lista obtenerDescendientes (Object elem){
        Lista lis = new Lista();
        if (!esVacio()) {
            buscarDescendientes(this.raiz, lis, elem);
        }
        return lis;
    }
    
    private boolean buscarDescendientes(NodoArbol n, Lista lis, Object elem){
        boolean encontrado = false;
        if (n != null) {
            if (n.getElem().equals(elem)) {
                encontrado = true;
            } else {
                encontrado = buscarAncestros(n.getIzquierdo(), lis, elem);
                if (encontrado) {
                    lis.insertar(n.getElem(), lis.longitud()+1);
                } else {
                    encontrado = buscarAncestros(n.getDerecho(), lis, elem);
                    if (encontrado) {
                        lis.insertar(n.getElem(), lis.longitud()+1);
                    }
                }
            }
        }
        return encontrado;
    }*/
    public ArbolBin cloneInvertido() {
        //Genera y devuelve una cadena de caracteres que indica cuál es la raíz 
        //del árbol y quienes son los hijos de cada nodo.
        ArbolBin clon = new ArbolBin();
        if (!esVacio()) {
            //si no es vacio el arbol, retorna un nuevo arbol invertido
            clon.raiz = cloneInvertidoAux(this.raiz);
        }
        return clon;
    }

    private NodoArbol cloneInvertidoAux(NodoArbol n) {
        NodoArbol nuevo = new NodoArbol(n.getElem(), null, null);
        if (n.getDerecho() != null) {
            //si existe HD, le asignamos como HI de "nuevo"
            nuevo.setIzquierdo(cloneInvertidoAux(n.getDerecho()));
        }
        if (n.getIzquierdo() != null) {
            //si existe HI, le asignamos como HD de "nuevo"
            nuevo.setDerecho(cloneInvertidoAux(n.getIzquierdo()));
        }
        return nuevo;
    }

    public boolean verificarPatron(Lista patron) {
        boolean recorrido = false;
        if (esVacio()) {
            //si el arbol es vacio y patron es vacio, es verdadero
            recorrido = patron.esVacia();
        } else {
            //si no es vacio el arbol, recorre desde la raiz del arbol
            recorrido = verificarPatronAux(this.raiz, patron, recorrido, 1);
        }
        return recorrido;
    }

    public boolean verificarPatronAux(NodoArbol n, Lista lis, boolean recorrido, int num) {
        if (n != null) {
            if (n.getElem().equals(lis.recuperar(num))) {
                //si el elemento almacenado en num es igual, recorrido es verdadero
                recorrido = true;
            }
            //sigue recorriendo por el HI
            recorrido = verificarPatronAux(n.getIzquierdo(), lis, recorrido, num + 1);
            if (!recorrido) {
                //si el recorrido no se encontro, recorre por el HD
                recorrido = verificarPatronAux(n.getDerecho(), lis, recorrido, num + 2);
            }
        }
        return recorrido;
    }
}
