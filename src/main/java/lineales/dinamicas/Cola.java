/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineales.dinamicas;

import lineales.dinamicas.Nodo;
import lineales.dinamicas.Pila;

/**
 *
 * @author casa
 */
public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object nuevoElem) {
        /*Pone el elemento al final de la cola. Devuelve verdadero si el elemento 
        se pudo agregar en la estructura y falso en caso contrario.*/
        Nodo nuevoNodo = new Nodo(nuevoElem, null);
        if (esVacia()) {
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
        } else {
            this.fin.setEnlace(nuevoNodo);
            this.fin = nuevoNodo;
        }
        return true;
    }

    public boolean sacar() {
        /*Saca el elemento que está en el frente de la cola. Devuelve verdadero 
        si el elemento se pudo sacar (la estructura no estaba vacía) y falso en caso contrario.*/
        boolean exito = true;
        if (this.frente == null) {
            // la cola esta vacia, reporta error
            exito = false;
        } else {
            // al menos hay un elemento:
            // quita el primer elemento y actualiza frente (y fin si queda vacia)
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        /*Devuelve el elemento que está en el frente. Precondición: la cola no está vacía.*/
        Object elem = null;
        if (!esVacia()) {
            elem = this.frente.getElem();
        }
        return elem;
    }

    public boolean esVacia() {
        /*Devuelve verdadero si la cola no tiene elementos y falso en caso contrario*/
        return (this.frente == null & this.fin == null);
    }

    public void vaciar() {
        /*Saca todos los elementos de la estructura.*/
        this.frente = null;
        this.fin = null;
    }

    public Cola clone() {
        /*Devuelve una copia exacta de los datos en la estructura original, 
        y respetando el orden de los mismos, en otra estructura del mismo tipo*/
        Cola clon = new Cola();
        Nodo aux1 = this.frente;
        clon.frente = new Nodo(aux1.getElem(), null);
        aux1 = aux1.getEnlace();
        Nodo aux2 = clon.frente;
        while (aux1 != null) {
            aux2.setEnlace(new Nodo(aux1.getElem(), null));
            aux2 = aux2.getEnlace();
            aux1 = aux1.getEnlace();
        }
        clon.fin = aux2;
        return clon;
    }

    public String toString() {
        /*Crea y devuelve una cadena de caracteres formada por todos los elementos 
        de la cola para poder mostrarla por pantalla. Es recomendable utilizar 
        este método únicamente en la etapa de prueba y luego comentar el código.*/
        String cadCola = "Cola vacia";
        if (!esVacia()) {
            Nodo aux = this.frente;
            cadCola = "[";
            while (aux != null) {
                cadCola = cadCola + aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    cadCola = cadCola + ",";
                }
            }
            cadCola = cadCola + "]";
        }
        return cadCola;
    }
    
    private int cuentaSecuenciasAux(Nodo n, Pila p1){
        int contador = 0;
        if (n != null) {
            Nodo aux = apilarYEncontrar(p1, n);
            if (verificarCapicua(p1, n)) {
                contador = 1 + cuentaSecuenciasAux(aux.getEnlace(), p1);
            } else {
                contador = cuentaSecuenciasAux(aux.getEnlace(), p1);
            }
        }
        return contador;
    }
    
    private Nodo apilarYEncontrar(Pila p1, Nodo n){
        Nodo aux=null;
        if (n!= null) {
            if (!n.getElem().equals('$')) {
                p1.apilar(n.getElem());
                aux = apilarYEncontrar(p1, n.getEnlace());
            } else {
                aux = n;
            }
        }
        return aux;
    }
    
    private boolean verificarCapicua (Pila p1, Nodo n){
        boolean capicua = true;
        if (!p1.esVacia() &&(n != null || !n.getElem().equals('$'))) {
            Object elem = p1.obtenerTope();
            p1.desapilar();
            if (n.getElem().equals(elem)) {
                capicua = verificarCapicua(p1, n);
            } else {
                capicua = false;
                p1.vaciar();
            }
        }
        return capicua;
    }
}
