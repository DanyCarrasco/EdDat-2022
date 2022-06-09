/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.finales;
import lineales.dinamicas.Pila;

/**
 *
 * @author casa
 */
public class TestPilaDinamica {
    public static void main(String[] args) {
        Pila pila1 = new Pila();
        System.out.println(pila1.toString());
        pila1.apilar(1);
        System.out.println(pila1.toString());
        pila1.apilar(2);
        System.out.println(pila1.toString());
        pila1.apilar(3);
        System.out.println(pila1.toString());
        pila1.apilar(4);
        System.out.println(pila1.toString());
        pila1.apilar(5);
        System.out.println(pila1.toString());
        pila1.apilar(6);
        System.out.println(pila1.toString());
        pila1.apilar(7);
        System.out.println(pila1.toString());
        pila1.apilar(8);
        System.out.println(pila1.toString());
        pila1.apilar(9);
        System.out.println(pila1.toString());
        pila1.apilar(10);
        System.out.println(pila1.toString());
        pila1.apilar(11);
        System.out.println(pila1.toString());
        System.out.println("Si se desapila el elemento 11 devuelve true:");
        if (pila1.desapilar()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        Pila pila2 = pila1.clone();
        System.out.println("Esta es la pila clonada de pila1:");
        System.out.println(pila2.toString());
        System.out.println("Ahora vamos a vaciar la pila1 debe retornar true:");
        pila1.vaciar();;
        if (pila1.esVacia()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(pila1.toString());
        System.out.println("Si se obtiene el elemento tope de pila retorna 'true'");
        System.out.println("Antes de obtener el elemento en el tope");
        if ((int)pila1.obtenerTope() == 10) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
