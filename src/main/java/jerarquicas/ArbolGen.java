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
public class ArbolGen {

    //atributos
    private NodoGen raiz;

    //constructor
    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        /* Dado un elemento elemNuevo y un elemento elemPadre, agrega elemNuevo como hijo de la primer
           aparición de elemPadre. Para que la operación termine con éxito debe existir un nodo en el árbol con
           elemento = elemPadre. No se establece ninguna preferencia respecto a la posición del hijo respecto a sus
           posibles hermanos. Esta operación devuelve verdadero cuando se pudo agregar elemNuevo a la estructura
           y falso en caso contrario.*/
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoGen(elemNuevo, null, null);
        } else {
            NodoGen nPadre = obtenerNodo(this.raiz, elemPadre);
            if (nPadre != null) {
                if (nPadre.getHijoIzquierdo() == null) {
                    nPadre.setHijoIzquierdo(new NodoGen(elemNuevo, null, null));
                } else {
                    NodoGen hijo = nPadre.getHijoIzquierdo();
                    while (hijo.getHermanoDerecho() != null) {
                        hijo = hijo.getHermanoDerecho();
                    }
                    hijo.setHermanoDerecho(new NodoGen(elemNuevo, null, null));
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        //metodo PRIVADO que busca un elemento y devuelve el nodo que 
        //lo contiene. Si no se encuentra retorna null
        NodoGen resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //Si el buscado es n, lo devuelve 
                resultado = n;
            } else {
                //no es el buscado; busca primero en el hijo HI
                resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);
                //si no lo encuentra en el HI, busca en HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getHermanoDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean pertenece(Object elem) {
        //Devuelve verdadero si el elemento pasado por parámetro está en el árbol, y falso en caso contrario.
        return obtenerNodo(this.raiz, elem) != null;
    }

    public Lista ancestros(Object elem) {
        /*Si el elemento se encuentra en el árbol, devuelve una lista con el camino desde la raíz hasta dicho
        elemento (es decir, con los ancestros del elemento). Si el elemento no está en el árbol devuelve la lista
        vacía.*/
        Lista lis = new Lista();
        ancestrosAux(this.raiz, elem, lis, 1);
        return lis;
    }

    private boolean ancestrosAux(NodoGen n, Object buscado, Lista ls, int pos) {
        boolean exito = false;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si es el elemento encontrado
                exito = true;
            } else {
                //Inserta sus ancestros
                ls.insertar(n.getElem(), pos);
                NodoGen hijo = n.getHijoIzquierdo();

                while (hijo != null && !exito) {
                    exito = ancestrosAux(hijo, buscado, ls, pos + 1);
                    hijo = hijo.getHermanoDerecho();
                }
                if (!exito) {
                    ls.eliminar(pos);
                }
            }
        }
        return exito;
    }

    public boolean esVacio() {
        // Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en caso contrario.
        return this.raiz == null;
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoGen n) {
        int aux = -1;
        int res = -1;
        if (n != null) {
            NodoGen h = n.getHijoIzquierdo();
            while (h != null) {
                aux = alturaAux(h);
                if (aux > res) {
                    res = aux;
                }
                h = h.getHermanoDerecho();
            }
            res++;
        }
        return res;
    }

    public Object nivel(Object elem) {
        return nivelAux(this.raiz, elem, 0);
    }

    private Object nivelAux(NodoGen n, Object elem, int piso) {
        Object res = -1;
        if (n != null) {
            if (n.getElem() == elem) {
                res = piso;
            } else {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null && res.equals(-1)) {
                    res = nivelAux(hijo, elem, piso + 1);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return res;
    }

    public Object padre(Object elem) {
        Object padre = null;
        if (this.raiz != null) {
            if (!this.raiz.getElem().equals(elem)) {
                padre = padreAux(this.raiz, elem);
            }
        }
        return padre;
    }

    private Object padreAux(NodoGen nodo, Object elemento) {
        Object resultado = null;

        if (nodo != null) {
            boolean val = false;
            if (nodo.getElem().equals(elemento)) {
                val = true;
            }
            if (!val) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && resultado == null) {
                    boolean value = false;
                    if (hijo.getElem().equals(elemento)) {
                        value = true;
                    }
                    if (value) {
                        resultado = nodo.getElem();
                    } else {
                        resultado = padreAux(hijo, elemento);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
        return resultado;
    }

    public Lista listarPreorden() {
        // Devuelve una lista con los elementos del árbol en el recorrido en preorden
        Lista salida = new Lista();
        listarPreordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPreordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);

            //llamado recursivo con primer hijo n
            listarPreordenAux(n.getHijoIzquierdo(), ls);

            //llamado recursivo con los otros hijos de n
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPreordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarInorden() {
        // Devuelve una lista con los elementos del árbol en el recorrido en inorden
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //llamado recursivo con primer hijo de n
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }

            //visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);

            //llamados recursivos con los otros hijos de n
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        // Devuelve una lista con los elementos del árbol en el recorrido en posorden
        Lista salida = new Lista();
        listarPosordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPosordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //llamado recursivo con primer hijo de n
            listarPosordenAux(n.getHijoIzquierdo(), ls);

            //llamados recursivos con los otros hijos de n
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPosordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }

            //visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        // Devuelve una lista con los elementos del árbol en el recorrido por niveles
        Lista salida = new Lista();
        Cola Q = new Cola();
        Q.poner(this.raiz);
        while (!Q.esVacia()) {
            NodoGen nodo = (NodoGen) Q.obtenerFrente();
            Q.sacar();
            if (nodo != null) {
                salida.insertar(nodo.getElem(), salida.longitud() + 1);
                Q.poner(nodo.getHijoIzquierdo());
                if (nodo.getHijoIzquierdo() != null) {
                    NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                    while (hijo != null) {
                        Q.poner(hijo);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
        return salida;
    }

    public ArbolGen clone() {
        // Genera y devuelve un árbol genérico que es equivalente (igual estructura y contenido de los nodos) que
        //el árbol original.
        ArbolGen clon = new ArbolGen();
        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }
        return clon;
    }

    private NodoGen cloneAux(NodoGen n) {
        NodoGen nuevo = new NodoGen(n.getElem(), null, null);
        if (n.getHijoIzquierdo() != null) {
            nuevo.setHijoIzquierdo(cloneAux(n.getHijoIzquierdo()));
        }
        if (n.getHermanoDerecho() != null) {
            nuevo.setHermanoDerecho(cloneAux(n.getHermanoDerecho()));
        }
        return nuevo;
    }

    public void vaciar() {
        // Quita todos los elementos de la estructura.
        this.raiz = null;
    }

    public String toString() {
        // Genera y devuelve una cadena de caracteres que indica cuál es la raíz del árbol y quienes son los hijos de cada nodo.
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            //visita del nodo n
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            // comienza recorrido de los hijos de n llamando recursivamente
            // para que cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    public Lista frontera() {
        Lista lis = new Lista();
        if (this.raiz != null) {
            fronteraAux(this.raiz, lis);
        }
        return lis;
    }

    private void fronteraAux(NodoGen n, Lista ls) {
        if (n != null) {
            if (n.getHijoIzquierdo() == null) {
                ls.insertar(n.getElem(), ls.longitud() + 1);
            } else {
                NodoGen hijo = n.getHijoIzquierdo();
                while (hijo != null) {
                    fronteraAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public boolean sonFrontera(Lista unaLista) {
        boolean respuesta = false;
        if (this.raiz != null && !unaLista.esVacia()) {
            Lista clon = new Lista();
            clon = unaLista.clone();
            sonFronteraAux(this.raiz, clon);
            if (clon.longitud() == 0) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    private void sonFronteraAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {
            if (nodo.getHijoIzquierdo() == null) {
                int i = lis.localizar(nodo.getElem());
                if (i != -1) {
                    lis.eliminar(i);
                }
            } else {
                NodoGen aux = nodo.getHijoIzquierdo();
                while (aux != null) {
                    sonFronteraAux(aux, lis);
                    aux = aux.getHermanoDerecho();
                }
            }

        }

    }
}
