/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas;

import lineales.dinamicas.Lista;

/**
 *
 * @author casa
 */
public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento, null, null);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemento) {
        //precondicion n no es nulo
        boolean exito = true;

        if (elemento.compareTo(n.getElem()) == 0) {
            //Reporta error; Elemento repetido
            exito = false;
        } else {
            if (elemento.compareTo(n.getElem()) < 0) {
                //elemento es menor que n.getElem()
                //si tiene HI baja a la izquierda, sino agrega elemento
                if (n.getIzquierdo() != null) {
                    exito = insertarAux(n.getIzquierdo(), elemento);
                } else {
                    n.setIzquierdo(new NodoABB(elemento, null, null));
                }
            } else {// elemento es mayor que n.getElem()
                //si tiene HD baja a la derecha, sino agrega elemento
                if (n.getDerecho() != null) {
                    exito = insertarAux(n.getDerecho(), elemento);
                } else {
                    n.setDerecho(new NodoABB(elemento, null, null));
                }
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elem) {
        return eliminarAux(this.raiz, null, elem);
    }

    private boolean eliminarAux(NodoABB n, NodoABB padre, Comparable elem) {
        boolean exito = false;
        if (n != null) {
            int comp = elem.compareTo(n.getElem());
            if (comp == 0) {
                exito = true;
                //si es el elemento buscado
                casos(n, padre);
            } else {
                //Si no es elemento buscado
                if (comp < 0) {
                    //Si es menor, busca en el subarbol izquierdo
                    exito = eliminarAux(n.getIzquierdo(), n, elem);
                } else {
                    //si es mayor, busca en el subarbol derecho
                    exito = eliminarAux(n.getDerecho(), n, elem);
                }
            }
        }
        return exito;
    }

    public void casos(NodoABB n, NodoABB padre) {
        if (n.getIzquierdo() == null && n.getDerecho() == null) {
            //es una hoja
            caso1(padre, n);
        } else {
            if (n.getIzquierdo() != null && n.getDerecho() != null) {
                //tiene dos hijos
                caso3(n, n.getDerecho());
            } else {
                //tiene un hijo
                if (n.getIzquierdo() != null) {
                    caso2(padre, n, n.getIzquierdo());
                } else {
                    caso2(padre, n, n.getDerecho());

                }
            }
        }
    }

    private void caso1(NodoABB padre, NodoABB nodo) {
        if (this.raiz == padre) {
            this.raiz = null;
        } else {
            if (padre.getIzquierdo() != null && padre.getIzquierdo().getElem().compareTo(nodo.getElem()) == 0) {
                //el hijo izquierdo se cambia por null
                padre.setIzquierdo(null);
            } else {
                //el hijo derecho se cambia por null
                padre.setDerecho(null);
            }
        }
    }

    private void caso2(NodoABB padre, NodoABB nodo, NodoABB hijo) {
        if (this.raiz == padre) {
            this.raiz = null;
        } else {
            if (nodo.getElem().compareTo(hijo.getElem()) < 0) {
                padre.setIzquierdo(hijo);
            } else {
                padre.setDerecho(hijo);
            }
        }
    }

    private void caso3(NodoABB nodo, NodoABB hijo) {

        if (hijo.getIzquierdo() == null) {
            //  el candidato es el hijo derecho del nodo
            NodoABB nodoHijoDer = hijo.getDerecho();
            nodo.setElem(hijo.getElem());
            nodo.setDerecho(nodoHijoDer);
        } else {
            // sino busco al candidato
            NodoABB candidato = nodo.getDerecho();
            while (candidato.getIzquierdo() != null) {
                candidato = candidato.getIzquierdo();
                if (candidato.getIzquierdo() != null) {
                    //  
                    hijo = hijo.getIzquierdo();
                }
            }
            nodo.setElem(candidato.getElem());
            hijo.setIzquierdo(candidato.getDerecho());
        }
    }

    /*private void caso3(NodoABB n, NodoABB hijoIzq) {
        //Primero buscamos el minimo de su subarbol izquierdo
        NodoABB hijoMinDer = buscarMinDer(n.getDerecho());
        //A n le aigna null
        n = null;
        //cambia el hijo izquierdo de n con el hijoIzq del nodo para eliminar
        hijoMinDer.setIzquierdo(hijoIzq);
        
    }*/
 /*private void caso3(NodoABB nodo, NodoABB hijo) {

        if (hijo.getIzquierdo() == null) {
            //  el candidato es el hijo derecho del nodo
            nodo.setElem(hijo.getElem());
            nodo.setDerecho(null);
        } else {
            // sino busco al candidato
            NodoABB candidato = buscarMinDer(nodo.getDerecho());
            nodo.setElem(candidato.getElem());
            hijo.setIzquierdo(candidato.getDerecho());
        }
    }*/
    private NodoABB buscarMinDer(NodoABB n) {
        NodoABB encontrado = null;
        if (n != null) {
            if (n.getIzquierdo() == null) {
                encontrado = n;
            } else {
                encontrado = buscarMinDer(n.getIzquierdo());
            }
        }
        return encontrado;
    }

    public boolean pertenece(Comparable elem) {
        //Devuelve verdadero si el elemento recibido por parámetro está en el árbol y falso en caso contrario.
        return perteneceAux(this.raiz, elem);
    }

    private boolean perteneceAux(NodoABB n, Comparable elem) {
        boolean resp = false;
        if (n != null) {
            if (elem.compareTo(n.getElem()) == 0) {
                resp = true;
            } else {
                if (elem.compareTo(n.getElem()) < 0) {
                    resp = perteneceAux(n.getIzquierdo(), elem);
                } else {
                    resp = perteneceAux(n.getDerecho(), elem);
                }
            }
        }
        return resp;
    }

    public boolean esVacio() {
        // Devuelve falso si hay al menos un elemento en el árbol y verdadero en caso contrario.
        return this.raiz == null;
    }

    public Lista listar() {
        // retorna una lista con los elementos del arbol en INORDEN
        Lista lis = new Lista();
        listarAux(this.raiz, lis);
        return lis;
    }

    private void listarAux(NodoABB nodo, Lista lis) {
        // metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            // recorre a sus hijos en inorden
            // recorre a su hijo izquierdo
            listarAux(nodo.getIzquierdo(), lis);     //(1)

            // visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); //(2)

            // visita a su hijo derecho
            listarAux(nodo.getDerecho(), lis);       //(3)
        }
    }

    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        // retorna una lista con los elementos del arbol en INORDEN
        Lista lis = new Lista();
        listarRangoAux(this.raiz, lis, elemMinimo, elemMaximo);
        return lis;
    }

    private void listarRangoAux(NodoABB nodo, Lista lis, Comparable elemMinimo, Comparable elemMaximo) {
        // metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            // recorre a sus hijos en inorden
            if (nodo.getElem().compareTo(elemMinimo) > 0) {
                // recorre a su hijo izquierdo
                listarRangoAux(nodo.getIzquierdo(), lis, elemMinimo, elemMaximo);     //(1)
            }
            if (nodo.getElem().compareTo(elemMinimo) >= 0 && nodo.getElem().compareTo(elemMaximo) <= 0) {
                // visita el elemento en el nodo
                lis.insertar(nodo.getElem(), lis.longitud() + 1); //(2)
            }

            if (nodo.getElem().compareTo(elemMaximo) < 0) {
                // visita a su hijo derecho
                listarRangoAux(nodo.getDerecho(), lis, elemMinimo, elemMaximo);       //(3)
            }
        }
    }

    private NodoABB obtenerNodo(NodoABB n, Comparable buscado) {
        //metodo PRIVADO que busca un elemento y devuelve el nodo que 
        //lo contiene. Si no se encuentra retorna null
        NodoABB resultado = null;
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

    /*public Comparable minimoElem(){
        // recorre la rama correspondiente y devuelve el elemento más pequeño almacenado en el árbol.
        Comparable min;
        NodoABB n = this.raiz;
        while (n.getIzquierdo() != null) {
            n = n.getIzquierdo();
        }
        min = (Comparable) n.getElem();
        return min;
    }*/
    public Comparable minimoElem() {
        // recorre la rama correspondiente y devuelve el elemento más pequeño almacenado en el árbol.
        return minimoElemAux(this.raiz);
    }

    private Comparable minimoElemAux(NodoABB n) {
        Comparable min;
        if (n.getIzquierdo() == null) {
            min = (Comparable) n.getElem();
        } else {
            min = minimoElemAux(n.getIzquierdo());
        }
        return min;
    }

    /*public Comparable maximoElem(){
        // recorre la rama correspondiente y devuelve el elemento más grande almacenado en el árbol.
        Comparable max;
        NodoABB n = this.raiz;
        while (n.getIzquierdo() != null) {
            n = n.getIzquierdo();
        }
        max = (Comparable) n.getElem();
        return max;
    }*/
    public Comparable maximoElem() {
        // recorre la rama correspondiente y devuelve el elemento más grande almacenado en el árbol.
        return maximoElemAux(this.raiz);
    }

    private Comparable maximoElemAux(NodoABB n) {
        Comparable max;
        if (n.getDerecho() == null) {
            max = (Comparable) n.getElem();
        } else {
            max = maximoElemAux(n.getDerecho());
        }
        return max;
    }

    public ArbolBB clone() {
        //Genera y devuelve una cadena de caracteres que indica cuál es la raíz 
        //del árbol y quienes son los hijos de cada nodo.
        ArbolBB clon = new ArbolBB();
        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }
        return clon;
    }

    private NodoABB cloneAux(NodoABB n) {
        NodoABB nuevo = new NodoABB(n.getElem(), null, null);
        if (n.getIzquierdo() != null) {
            nuevo.setIzquierdo(cloneAux(n.getIzquierdo()));
        }
        if (n.getDerecho() != null) {
            nuevo.setDerecho(cloneAux(n.getDerecho()));
        }
        return nuevo;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        String cadena = "Arbol vacio";
        if (this.raiz != null) {
            cadena = stringAux(this.raiz, "");
        }
        return cadena;
    }

    private String stringAux(NodoABB nodo, String cadena) {
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

    public void eliminarMinimo() {
        if (this.raiz.getIzquierdo() != null) {
            eliminarMinimoAux(this.raiz.getIzquierdo(), this.raiz);
        }
    }

    private void eliminarMinimoAux(NodoABB n, NodoABB padre) {
        if (n.getIzquierdo() == null) {
            padre.setIzquierdo(n.getDerecho());
        } else {
            eliminarMinimoAux(n.getIzquierdo(), n);
        }
    }

    public ArbolBB clonarParteInvertida(Comparable elem) {
        ArbolBB arbolClon = new ArbolBB();
        arbolClon.raiz = clonarParteInvertida2(elem, this.raiz);
        return arbolClon;
    }

    private NodoABB clonarParteInvertida2(Comparable elem, NodoABB n) {
        NodoABB clonInvertido = null;
        if (n != null) {
            if (n.getElem().compareTo(elem) == 0) {
                clonInvertido = invertir(n);
            } else {
                if (n.getElem().compareTo(elem) < 0) {
                    clonInvertido = clonarParteInvertida2(elem, n.getIzquierdo());
                } else {
                    clonInvertido = clonarParteInvertida2(elem, n.getDerecho());
                }
            }
        }
        return clonInvertido;
    }

    private NodoABB invertir(NodoABB n) {
        NodoABB nInvertido = null;
        if (n != null) {
            nInvertido = new NodoABB(n.getElem(), null, null);
            nInvertido.setIzquierdo(invertir(n.getDerecho()));
            nInvertido.setDerecho(invertir(n.getIzquierdo()));
        }
        return nInvertido;
    }
}
