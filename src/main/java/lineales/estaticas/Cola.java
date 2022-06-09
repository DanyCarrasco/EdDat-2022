/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.estaticas;

/**
 *
 * @author casa
 */
public class Cola {

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object nuevoElem) {
        /*Pone el elemento al final de la cola. 
	Devuelve verdadero si el elemento se pudo agregar en la estructura y 
	falso en caso contrario.*/
        boolean exito = false;
        if ((this.fin + 1) % TAMANIO != this.frente) {
            this.arreglo[this.fin] = nuevoElem;
            this.fin = (this.fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        /*Saca el elemento que está en el frente de la cola. 
	Devuelve verdadero si el elemento se pudo sacar 
	(la estructura no estaba vacía) y falso en caso contrario.*/
        boolean exito = true;
        if (this.esVacia()) // la cola esta vacia, reporta error
        {
            exito = false;
        } else // al menos hay 1 elemento: avanza frente (de manera circular)
        {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente() {
        //Devuelve el elemento que está en el frente. Precondición: la cola no está vacía.
        return this.arreglo[frente];
    }

    public boolean esVacia() {
        //Devuelve verdadero si la cola no tiene elementos y falso en caso contrario
        return frente == fin;
    }

    public void vaciar() {
        //Saca todos los elementos de la estructura.
        while (!esVacia()) {
            this.arreglo[frente] = null;
            this.frente = (frente + 1) % TAMANIO;
        }
        this.frente = 0;
        this.fin = 0;
    }

    public Cola clone() {
        /*Devuelve una copia exacta de los datos en la estructura original, 
	y respetando el orden de los mismos, en otra estructura del mismo tipo*/
        Cola clon = new Cola();
        clon.frente = this.frente;
        clon.fin = this.fin;
        for (int i = 0; i < clon.TAMANIO; i++) {
            clon.arreglo[i] = this.arreglo[i];
        }
        return clon;
    }

    public String toString() {
        /*Crea y devuelve una cadena de caracteres formada por todos los elementos 
	de la cola para podermostrarla por pantalla. 
	Es recomendable utilizar este método únicamente en la etapa de prueba y 
	luego comentar el código.*/
        String cadCola = "Cola vacia";
        if (!esVacia()) {
            cadCola = "[";
            int numFrente = this.frente, numFin = this.fin;
            while (numFrente != numFin) {
                cadCola+=this.arreglo[numFrente];
                if (numFrente+1 != numFin) {
                    cadCola +=",";
                } 
                numFrente = (numFrente + 1) % TAMANIO;
            }
            cadCola +="]";
        }
        return cadCola;
    }
}
