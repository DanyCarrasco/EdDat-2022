/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.finales;

import lineales.estaticas.Pila;

/**
 *
 * @author daniel.carrasco
 */
public class TestPila {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Apilamos elementos con un PARA y nos indica si lo hizo con exito
        Pila pilaEst = new Pila();
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
            System.out.println(pilaEst.apilar(i));
        }

        /*Probaremos con desapilar un elemento del tope (en este caso, 
        el elemento '10') y retorna si hubo exito en ello*/
        System.out.println("Desapilaremos el elemento del tope");
        if (pilaEst.desapilar()) {
            System.out.println("Se desapilo el elemento '10' del tope con exito");
        } else {
            System.out.println("No se desapilo el elemento '10' del tope con exito");
        }

        //Probramos obtenerTope el cual retorna el elemento del tope o retorna -1
        //si la pila esta vacia (en este caso debe retornar '9')
        System.out.println("Obtendremos el elemento del tope");
        if (-1 == (int) pilaEst.obtenerTope()) {
            System.out.println("En esta pila no hay elementos");
        } else {
            System.out.println(pilaEst.obtenerTope());
        }

        //Probamos esVacia el cual debe retornar un boolean para verificar si la 
        //pila no tiene elementos (en este caso debe retornar 'false')
        System.out.println("Verificamos si la pila tiene elementos");
        if (pilaEst.esVacia()) {
            System.out.println("Esta pila no tiene elementos");
        } else {
            System.out.println("Esta pila tiene elementos");
        }

        //Probamos vaciar el cual la pila y verificamos si funciona con el metodo
        //esVacia (en este caso debe retornar 'true')
        System.out.println("Ahora vamos a vaciar la pila");
        pilaEst.vaciar();
        if (pilaEst.esVacia()) {
            System.out.println("Ahora esta pila no tiene elementos");
        } else {
            System.out.println("Aun esta pila tiene elementos");
        }
        
        //Probamos clone para obtener un clon de la pila pilaEst y probaremos 
        //toString para verificar que tienen los mismos elementos
        for (int i = 1; i <= 10; i++) {
            pilaEst.apilar(i);
            System.out.println(pilaEst.obtenerTope());
        }
        Pila pilaAux;
        pilaAux = pilaEst.clone();
        pilaEst.toString();
        pilaAux.toString();
        
    }
}
