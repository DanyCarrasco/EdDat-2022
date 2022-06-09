/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author daniel.carrasco FAI-2840
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        /*Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero 
        si el elemento se pudo apilar y falso en caso contrario.*/
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar() {
        /*Saca el elemento del tope de la pila. Devuelve verdadero si la pila 
        no estaba vacía al momento de desapilar (es decir que se pudo desapilar) 
        y falso en caso contrario.*/
        boolean exito = false;
        //Precondicion: si la pila no esta vacia, desapila el tope de pila
        if (!esVacia()) {
            this.tope = tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        //Devuelve el elemento en el tope de la pila. Precondición: la pila no está vacía.
        Object elem = null;
        //Precondicion
        if (!esVacia()) {
            elem = this.tope.getElem();
        }
        return elem;
    }

    public boolean esVacia() {
        //Devuelve verdadero si la pila no tiene elementos y falso en caso contrario.
        return this.tope == null;
    }

    public void vaciar() {
        //Saca todos los elementos de la pila.
        this.tope = null;
    }

    public Pila clone() {
        /*Devuelve una copia exacta de los datos en la estructura original, 
        y respetando el orden de los mismos,en otra estructura del mismo tipo*/
        //Crea la pila 'clon' y 'temp' recorrera desde tope toda la pila
        Pila clon = new Pila();
        Nodo temp = this.tope;
        //'tempClon' une todos los nodos de la pila 'clon'
        Nodo tempClon;
        //Precondicion
        if (!esVacia()) {
            //'clonNodo' recorre en la pila 'clon' y copia todos los nodos
            Nodo clonNodo = new Nodo(temp.getElem(), null);
            clon.tope = clonNodo;
            tempClon = clon.tope;
            temp = temp.getEnlace();
            //Recorre hasta que 'temp' sea igual a 'null'
            while (temp != null) {
                //'clonNodo' crea un nuevo elemento en pila 'clon'
                clonNodo = new Nodo(temp.getElem(), null);
                //'tempClon' enlaza el nodo anterior
                tempClon.setEnlace(clonNodo);
                //'tempClon' y 'temp' avanzan al siguiente nodo
                tempClon = tempClon.getEnlace();
                temp = temp.getEnlace();
            }
        }
        return clon;
    }

    @Override
    public String toString() {
        /*Devuelve una cadena de caracteres formada por todos los elementos de 
        la pila para poder mostrarla por pantalla. Utilizado este método 
        únicamente en la etapa de prueba.*/
        String s = "Pila vacia";
        //Precondicion: si pila esta vacia retorna 'Pila vacia'
        if (!esVacia()) {
            //Se ubica para recorrer la pila
            Nodo aux = this.tope;
            s = "[";
            while (aux != null) {
                //agrega el texto del elem y avanza
                s = s + aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    s = s + ",";
                }
            }
            s = s + "]";
        }
        return s;
    }
}
