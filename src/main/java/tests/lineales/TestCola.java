/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

//import lineales.estaticas.Cola;
import lineales.dinamicas.Cola;

/**
 *
 * @author casa
 */
public class TestCola {

    public static void main(String[] args) {
        Cola c1 = new Cola();
        System.out.println("Ponemos el numero 1 en la cola, debe retornar true");
        System.out.println(c1.poner(1));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 2 en la cola, debe retornar true");
        System.out.println(c1.poner(2));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 3 en la cola, debe retornar true");
        System.out.println(c1.poner(3));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 4 en la cola, debe retornar true");
        System.out.println(c1.poner(4));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 5 en la cola, debe retornar false");
        System.out.println(c1.poner(5));
        System.out.println(c1.toString());
        /*System.out.println("Ponemos el numero 6 en la cola, debe retornar true");
        System.out.println(c1.poner(6));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 7 en la cola, debe retornar true");
        System.out.println(c1.poner(7));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 8 en la cola, debe retornar true");
        System.out.println(c1.poner(8));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 9 en la cola, debe retornar true");
        System.out.println(c1.poner(9));
        System.out.println(c1.toString());
        System.out.println("Ponemos el numero 10 en la cola, debe retornar false");
        System.out.println(c1.poner(10));
        System.out.println(c1.toString());*/

        System.out.println("Ahora sacaremos el numero 1 de la cola");
        c1.sacar();
        System.out.println(c1.toString());
        System.out.println("Ahora ponemos el numero 5 en la cola, debe retornar true");
        System.out.println(c1.poner(5));
        System.out.println(c1.toString());
        
        System.out.println("");
    }

}
