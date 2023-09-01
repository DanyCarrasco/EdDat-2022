/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author daniel.carrasco FAI-2840
 */
public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 10;

    public Pila() {
        // Crea y devuelve la pila vacía.
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElemento) {
        /*Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero 
        si el elemento se pudo apilar y falso en caso contrario.*/        
        //Retorna 'exito' y le asigno 'false'
        boolean exito = false;
        //Precondicion
        if (!(this.tope + 1 >= this.TAMANIO)) {
            //Incrementa al tope de la pila y le asigna el nuevoElemento a tope
            this.tope++;
            this.arreglo[tope] = nuevoElemento;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        /*Saca el elemento del tope de la pila. Devuelve verdadero si la pila 
        no estaba vacía al momento de desapilar (es decir que se pudo desapilar) 
        y falso en caso contrario.*/
        //Retorna 'exito' y le asignamos 'false'
        boolean exito = false;
        //Precondicion: para verificar que la pila no esta vacia
        if (!(this.tope == -1)) {
            //Asigna 'null' en el tope de Pila y decrementa a tope
            this.arreglo[tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        //Devuelve el elemento en el tope de la pila. Precondición: la pila no está vacía.
        //Retorna 'elem' y le asigno 'null'
        Object elem = null;
        //Precondicion
        if (!(this.tope == -1)) {
            elem = this.arreglo[tope];
        }
        return elem;
    }

    public boolean esVacia() {
        //Devuelve verdadero si la pila no tiene elementos y falso en caso contrario.
        return this.tope == -1;
    }

    public void vaciar() {
        //Saca todos los elementos de la pila.
        //Precondicion: se ejecuta mientras la pila no este vacia
        while (!(this.tope == -1)) {
            //Asigna 'null' al tope de Pila y decrementa tope
            arreglo[tope] = null;
            this.tope--;
        }
    }
    
    public Pila clone() {
        /*Devuelve una copia exacta de los datos en la estructura original, 
        y respetando el orden de los mismos, en otra estructura del mismo tipo*/
        //Crea 'clon' que retorna el metodo y asigno el mismo tope
        Pila clon = new Pila();
        clon.tope = this.tope;
        //Recorrido de for: desde 0 hasta tope+1 de la pila
        for (int i = 0; i < this.tope + 1; i++) {
            //Asigna el elemento de la pila en la posicion 'i'
            clon.arreglo[i] = this.arreglo[i];
        }
        return clon;
    }

    public String toString() {
        /*Devuelve una cadena de caracteres formada por todos los elementos de 
        la pila para poder mostrarla por pantalla. Metodo utilizado únicamente 
        en la etapa de prueba*/
        String cadPila = "Pila vacia";
        //Precondicion: si la pila no esta vacia
        if (!(this.tope == -1)) {
            cadPila = "[";
            for (int i = 0; i < this.tope + 1; i++) {
                cadPila = cadPila + this.arreglo[i];
                if (i < this.tope) {
                    cadPila = cadPila + ",";
                }
            }
            cadPila = cadPila + "]";
        }
        return cadPila;
    }

}
