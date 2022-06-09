/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Lista;

/**
 *
 * @author casa
 */
public class TestLista {

    public static void main(String[] args) {
        Lista lista1 = new Lista();
        System.out.println("Creamos una lista la cual se mostrara que esta vacia:");
        System.out.println(lista1.toString());
        System.out.println("Ingresa 'A' en la posicion 1 en la lista");
        lista1.insertar('A', 1);
        System.out.println(lista1.toString());
        System.out.println("Ingresa 'B' en la posicion 2 de la lista");
        lista1.insertar('B', 2);
        System.out.println(lista1.toString());
        System.out.println("Ingresa 'I' en la posicion 3");
        lista1.insertar('I', 3);
        System.out.println(lista1.toString());
        System.out.println("Ingresa 'A' en la posicion long+1 (4)");
        lista1.insertar('A', lista1.longitud() + 1);
        System.out.println(lista1.toString());
        // System.out.println("Ingresa 'C' en la posicion 5");
        //lista1.insertar('C', 5);
        //System.out.println(lista1.toString() + "\n");
        //System.out.println("Ingresa 'A' en la posicion 6");
        //lista1.insertar('A', 6);
        //System.out.println(lista1.toString() + "\n");

        System.out.println("Probamos con eliminarApariciones de A, retorna [B, I, C]");
        lista1.eliminarApariciones('A');
        System.out.println(lista1.toString());

    }

}
