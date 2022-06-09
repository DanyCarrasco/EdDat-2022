/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

import lineales.dinamicas.Nodo;

/**
 *
 * @author casa
 */
public class Lista {

    private Nodo cabecera;
    private int longitud;

    public Lista() {
        // Crea y devuelve una lista vacía.
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object nuevoElem, int pos) {
        /*Agrega el elemento pasado por parámetro en la posición pos, de manera 
        que la cantidad de elementos de la lista se incrementa en 1. 
        Para una inserción exitosa, la posición recibida debe ser 1 <= pos <= longitud(lista) + 1. 
        Devuelve verdadero si se puede insertar correctamente y falso en caso contrario.*/
        // inserta el elemento nuevo en la posicion pos
        // detecta y reporta error posicion invalida
        //  inserta el elemento nuevo en la posicion pos
        boolean exito = true;
        int longi = this.longitud;
        if (pos < 1 || pos > longi + 1) {
            //  detecta y reporta error posicion invalida
            exito = false;
        } else {
            if (pos == 1) {   //  crea un nuevo nodo y enlaza en la cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else {  //  avanza hasta el elemento en posicion pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //  crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;
        }
        //  nunca hay error de lista llena, entonces devuelve true
        return exito;
    }

    public boolean eliminar(int pos) {
        /*Borra el elemento de la posición pos, por lo que la cantidad de elementos 
        de la lista disminuye en uno. Para una eliminación exitosa, 
        la lista no debe estar vacía y la posición recibida debe ser 1 ≤ pos ≤ longitud(lista). 
        Devuelve verdadero si se pudo eliminar correctamente y falso en caso contrario.*/
        boolean exito = false;
        int numLong = this.longitud;
        if (!esVacia()) {
            if (pos >= 1 && pos <= numLong) {
                Nodo aux = this.cabecera;
                if (pos == 1) {
                    this.cabecera = aux.getEnlace();
                } else {
                    int i = 1;
                    while (i < pos - 1) {
                        aux = aux.getEnlace();
                        i++;
                    }
                    aux.setEnlace(aux.getEnlace().getEnlace());

                }
                this.longitud--;
                exito = true;
            }
        }
        return exito;
    }

    public Object recuperar(int pos) {
        //Devuelve el elemento de la posición pos. La precondición es que la posición sea válida.
        Object elem;
        int numLong = this.longitud, i;
        if (pos < 1 || pos > numLong) {
            elem = null;
        } else {
            Nodo aux = this.cabecera;
            if (pos == 1) {
                elem = this.cabecera.getElem();
            } else {
                i = 2;
                while (i <= pos) {
                    aux = aux.getEnlace();
                    i++;
                }
                elem = aux.getElem();
            }
        }
        return elem;
    }

    public int localizar(Object elem) {
        /*Devuelve la posición en la que se encuentra la primera ocurrencia de elem dentro de la lista. 
        En caso de no encontrarlo devuelve -1.*/
        int posElem = -1, i;
        if (!esVacia()) {
            Nodo aux = this.cabecera;
            i = 1;
            while (posElem == -1 && aux != null) {
                if (aux.getElem().equals(elem)) {
                    posElem = i;
                } else {
                    aux = aux.getEnlace();
                    i++;
                }
            }
        }
        return posElem;
    }

    public void vaciar() {
        /*Quita todos los elementos de la lista. El manejo de memoria es similar 
        al explicado anteriormente para Cola y Pila dinámicas.*/
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean esVacia() {
        //Devuelve verdadero si la lista no tiene elementos y falso en caso contrario.
        return this.longitud == 0;
    }

    public Lista clone() {
        /*Devuelve una copia exacta de los datos en la estructura original, 
        y respetando el orden de los mismos, en otra estructura del mismo tipo*/
        Lista clon = new Lista();
        Nodo aux = this.cabecera;
        if (!esVacia()) {
            clon.cabecera = new Nodo(aux.getElem(), null);
            Nodo aux2 = clon.cabecera;
            while (aux.getEnlace() != null) {
                aux = aux.getEnlace();
                aux2.setEnlace(new Nodo(aux.getElem(), null));
                aux2 = aux2.getEnlace();
            }
            clon.longitud = this.longitud;
        }
        return clon;
    }

    public int longitud() {
        //Devuelve la cantidad de elementos de la lista.
        //'this.longitud' retorna la cantidad de los nodos de la lista
        //'temp' recorrera toda la lista
        Nodo temp = this.cabecera;
        int i = 0;
        //Precondicion:
        while (temp != null) {
            temp = temp.getEnlace();
            i++;
        }
        return this.longitud = i;
    }

    public String toString() {
        /*Crea y devuelve una cadena de caracteres formada por todos los elementos 
        de la lista para poder mostrarla por pantalla. Es recomendable utilizar 
        este método únicamente en la etapa de prueba y luego comentar el código.*/
        String cadLista = "Lista vacia";
        int i, numLong = this.longitud;
        if (!esVacia()) {
            cadLista = "[";
            Nodo aux = this.cabecera;
            //i = 1;
            //while (i <= numLong)
            while (aux != null) {
                //cadLista = cadLista + aux.getElem().toString();
                cadLista = cadLista + aux.getElem();
                //i++;
                aux = aux.getEnlace();
                // if (i < numLong)
                if (aux != null) {
                    cadLista += ", ";
                }
            }
            cadLista = cadLista + "]";
        }
        return cadLista;
    }

    public Lista obtenerMultiplos(int num) {
        Lista lis = new Lista();
        Nodo aux = this.cabecera;
        int numLong = 0, i = 2;
        if (!(this.cabecera == null && this.longitud == 0)) {
            lis.cabecera = new Nodo(aux.getElem(), null);
            Nodo aux1 = lis.cabecera;
            while (aux.getEnlace() != null) {
                if ((i % num) == 0) {
                    aux = aux.getEnlace();
                    aux1.setEnlace(new Nodo(aux.getElem(), null));

                    aux1 = aux1.getEnlace();
                    i++;
                    numLong++;
                } else {
                    aux = aux.getEnlace();
                    i++;
                }
            }
            lis.longitud = numLong;
            if (num != 1) {
                lis.cabecera = lis.cabecera.getEnlace();
                lis.longitud = numLong - 1;
            }
        }
        return lis;
    }

    public void eliminarApariciones(Object elem) {
        int i = 1, numLong = this.longitud;
        Nodo aux = this.cabecera;
        while (i <= numLong) {
            if (aux.getElem().equals(elem)) {
                if (i == 1) {
                    this.cabecera = aux.getEnlace();
                } else {
                    int i2 = i;
                    while (i2 < numLong - 1) {
                        aux = aux.getEnlace();
                        i2++;
                    }
                    aux.setEnlace(aux.getEnlace().getEnlace());
                }
                numLong--;
                i++;
            } else {
                aux = aux.getEnlace();
                i++;
            }
        }
    }
}
