/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author Díaz Julian Emanuel
 */
public class testGenericoMio {

    public static void main(String[] args) {
        // A PARTIR DE ACA, DESPUES BORRA ESTE COMENTARIO
        ArbolGen arbol1 = new ArbolGen();

        System.out.println("Creamos el arbol 1");
        System.out.println("Inserto 1 en la raiz\t\t\t" + "true: " + arbol1.insertar(1, 1));
        System.out.println("Inserto 2 como hijo de 1\t\t" + "true: " + arbol1.insertar(2, 1));
        System.out.println("Inserto 3 como hijo de 1\t\t" + "true: " + arbol1.insertar(3, 1));
        System.out.println("Inserto 4 como hijo de 3\t\t" + "true: " + arbol1.insertar(4, 3));
        System.out.println("Inserto 5 como hijo de 4\t\t" + "true: " + arbol1.insertar(5, 4));
        System.out.println("Inserto 6 como hijo de 2\t\t" + "true: " + arbol1.insertar(6, 2));
        System.out.println("Inserto 7 como hijo de 2\t\t" + "true: " + arbol1.insertar(7, 2));
        System.out.println("Inserto 8 como hijo de 5\t\t" + "true: " + arbol1.insertar(8, 5));
        System.out.println("Inserto 9 como hijo de 5\t\t" + "true: " + arbol1.insertar(9, 5));
        System.out.println("Inserto 10 como hijo de 10\t\t" + "false: " + arbol1.insertar(10, 10) + "\n");
        System.out.println("String de arbol2:\n" + arbol1.toString());

        Lista prueba2 = new Lista();
        Lista prueba3 = new Lista();

        System.out.println("Creamos la lista prueba2");
        System.out.println("Inserto 1 en pos 1\t\t" + "true: " + prueba2.insertar(1, 1));
        System.out.println("Inserto 11 en pos 2\t\t" + "true: " + prueba2.insertar(11, 2));
        System.out.println("Pruebo si la lista prueba: " + prueba2.toString() + " es frontera, debe dar false: " + arbol1.sonFrontera(prueba2));
        System.out.println("Pruebo con lista vacia: " + prueba3.toString() + ", debe dar false: " + arbol1.sonFrontera(prueba2));
        System.out.println("Inserto 1 en pos 1\t\t" + "true: " + prueba3.insertar(1, 1));
        System.out.println("Inserto 2 en pos 1\t\t" + "true: " + prueba3.insertar(2, 1));
        System.out.println("Inserto 3 en pos 2\t\t" + "true: " + prueba3.insertar(3, 2));
        System.out.println("Inserto 4 en pos 1\t\t" + "true: " + prueba3.insertar(4, 1));
        System.out.println("Inserto 5 en pos 3\t\t" + "true: " + prueba3.insertar(5, 3));
        System.out.println("Inserto 6 en pos 2\t\t" + "true: " + prueba3.insertar(6, 2));
        System.out.println("Inserto 7 en pos 5\t\t" + "true: " + prueba3.insertar(7, 5));
        System.out.println("Inserto 8 en pos 3\t\t" + "true: " + prueba3.insertar(8, 3));
        System.out.println("Inserto 9 en pos 2\t\t" + "true: " + prueba3.insertar(9, 2));
        System.out.println("Inserto 10 en pos 8\t\t" + "true: " + prueba3.insertar(10, 8));
        System.out.println("Lista prueba3: \t\t" + prueba3.toString());
        System.out.println("Pruebo con lista prueba3, debe dar false:\t\t" + arbol1.sonFrontera(prueba3));
        prueba3.eliminar(1);
        prueba3.eliminar(4);
        prueba3.eliminar(4);
        prueba3.eliminar(5);
        prueba3.eliminar(5);
        prueba3.eliminar(5);
        System.out.println("Lista prueba3: \t\t" + prueba3.toString());
        System.out.println("Pruebo con lista prueba3, debe dar true:\t\t" + arbol1.sonFrontera(prueba3));

    }

}
