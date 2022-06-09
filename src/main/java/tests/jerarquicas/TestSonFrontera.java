/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author Díaz Julian Emanuel y Carrasco Cifuentes Daniel Alexis
 */
public class TestSonFrontera {

    public static void main(String[] args) {
        System.out.println("Arboles genericos formados por Numeros");
        System.out.println("Creamos las listas prueba1, prueba2, prueba3 y prueba4");
        Lista prueba1 = new Lista();
        Lista prueba2 = new Lista();
        Lista prueba3 = new Lista();
        Lista prueba4 = new Lista();

        System.out.println("Creamos Arbol 1");
        ArbolGen arbol1 = new ArbolGen();
        System.out.println("Ingresamos la prueba");
        System.out.println("Lista de fronteras []");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna true");
        System.out.println(arbol1.sonFrontera(prueba1));
        
        Lista hojas1 = arbol1.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol1, retorna true");
        System.out.println(arbol1.sonFrontera(hojas1) + "\n");

        System.out.println("Ingreso 1 como raiz en el arbol1");
        arbol1.insertar(1, 1);
        System.out.println(arbol1.toString());
        System.out.println("Ingresamos la prueba");
        System.out.println("Lista de fronteras [1]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol1.sonFrontera(prueba1));
        hojas1 = arbol1.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol1, retorna true");
        System.out.println(arbol1.sonFrontera(hojas1) + "\n");

        System.out.println("Ingreso 2 como hijo de 1 en el arbol1");
        arbol1.insertar(2, 1);
        System.out.println(arbol1.toString());
        System.out.println("Ingresamos la prueba");
        System.out.println("Lista de fronteras [2]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol1.sonFrontera(prueba1));
        hojas1 = arbol1.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol1, retorna true");
        System.out.println(arbol1.sonFrontera(hojas1) + "\n");

        System.out.println("Ingreso 3 como hijo de 1 en el arbol1");
        arbol1.insertar(3, 1);
        System.out.println(arbol1.toString());
        System.out.println("Ingreso 4 como hijo de 1 en el arbol1");
        arbol1.insertar(4, 1);
        System.out.println(arbol1.toString());
        System.out.println("Ingresamos las pruebas");
        System.out.println("Lista de fronteras [2,3,4]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol1.sonFrontera(prueba1));
        prueba2.insertar(4, 1);
        System.out.println("Prueba2: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba2, retorna true");
        System.out.println(arbol1.sonFrontera(prueba2));
        prueba2.vaciar();;
        prueba3.insertar(2, 1);
        prueba3.insertar(3, 2);
        prueba3.insertar(4, 3);
        prueba3.insertar(5, 4);
        System.out.println("Prueba3: " + prueba3.toString());
        System.out.println("Probamos el metodo con prueba3, retorna false");
        System.out.println(arbol1.sonFrontera(prueba3));
        prueba3.vaciar();
        prueba4.insertar(4, 1);
        prueba4.insertar(2, 2);
        prueba4.insertar(3, 3);
        System.out.println("Prueba4: " + prueba4.toString());
        System.out.println("Probamos el metodo con prueba4, retorna true");
        System.out.println(arbol1.sonFrontera(prueba4));
        prueba4.vaciar();

        hojas1 = arbol1.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol1, retorna true");
        System.out.println(arbol1.sonFrontera(hojas1) + "\n");

        System.out.println("Creo arbol2 clonando arbol1");
        ArbolGen arbol2 = arbol1.clone();
        System.out.println(arbol2.toString());
        System.out.println("Ingreso 5 como hijo de 2 en arbol2");
        arbol2.insertar(5, 2);
        System.out.println(arbol2.toString());
        System.out.println("Ingresamos las pruebas");
        System.out.println("Lista de fronteras [5,3,4]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol2.sonFrontera(prueba1));
        prueba2.insertar(4, 1);
        System.out.println("Prueba2: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba2, retorna true");
        System.out.println(arbol2.sonFrontera(prueba2));
        prueba2.vaciar();
        prueba3.insertar(5, 1);
        prueba3.insertar(3, 2);
        prueba3.insertar(4, 3);
        prueba3.insertar(6, 4);
        System.out.println("Prueba3: " + prueba3.toString());
        System.out.println("Probamos el metodo con prueba3, retorna false");
        System.out.println(arbol2.sonFrontera(prueba3));
        prueba3.vaciar();
        prueba4.insertar(4, 1);
        prueba4.insertar(3, 2);
        prueba4.insertar(5, 3);
        System.out.println("Prueba4: " + prueba4.toString());
        System.out.println("Probamos el metodo con prueba4, retorna true");
        System.out.println(arbol2.sonFrontera(prueba4));
        prueba4.vaciar();

        Lista hojas2 = arbol2.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol2, retorna true");
        System.out.println(arbol2.sonFrontera(hojas2) + "\n");

        System.out.println("Creo arbol3 clonando arbol1");
        ArbolGen arbol3 = arbol1.clone();
        System.out.println(arbol3.toString());
        System.out.println("Ingreso 5 como hijo de 4 en arbol3");
        arbol3.insertar(5, 4);
        System.out.println("Ingreso 6 como hijo de 4 en arbol3");
        arbol3.insertar(6, 4);
        System.out.println("Ingreso 7 como hijo de 4 en arbol3");
        arbol3.insertar(7, 4);
        System.out.println(arbol3.toString());
        System.out.println("Ingresamos la prueba");
        System.out.println("Lista de fronteras [2,3,5,6,7]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol1.sonFrontera(prueba1));
        prueba2.insertar(5, 1);
        System.out.println("Prueba2: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba2, retorna true");
        System.out.println(arbol3.sonFrontera(prueba2));
        prueba2.vaciar();
        prueba3.insertar(2, 1);
        prueba3.insertar(3, 2);
        prueba3.insertar(5, 3);
        prueba3.insertar(6, 4);
        prueba3.insertar(7, 5);
        prueba3.insertar(8, 6);
        System.out.println("Prueba3: " + prueba3.toString());
        System.out.println("Probamos el metodo con prueba3, retorna false");
        System.out.println(arbol3.sonFrontera(prueba3));
        prueba3.vaciar();
        prueba4.insertar(2, 1);
        prueba4.insertar(6, 2);
        prueba4.insertar(3, 3);
        prueba4.insertar(7, 4);
        prueba4.insertar(5, 5);
        System.out.println("Prueba4: " + prueba4.toString());
        System.out.println("Probamos el metodo con prueba4, retorna true");
        System.out.println(arbol3.sonFrontera(prueba4));
        prueba4.vaciar();

        Lista hojas3 = arbol3.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol3, retorna true");
        System.out.println(arbol3.sonFrontera(hojas3) + "\n");

        System.out.println("Creo arbol4 clonando arbol1");
        ArbolGen arbol4 = arbol1.clone();
        System.out.println("Ingreso 5 como hijo de 2 en arbol3");
        arbol4.insertar(5, 2);
        System.out.println("Ingreso 6 como hijo de 4 en arbol3");
        arbol4.insertar(6, 4);
        System.out.println("Ingreso 7 como hijo de 4 en arbol3");
        arbol4.insertar(7, 4);
        System.out.println("Ingreso 8 como hijo de 4 en arbol3");
        arbol4.insertar(8, 4);
        System.out.println(arbol4.toString());
        System.out.println("Ingresamos las pruebas");
        System.out.println("Lista de fronteras [5,3,6,7,8]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol4.sonFrontera(prueba1));
        prueba2.insertar(6, 1);
        System.out.println("Prueba2: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba2, retorna true");
        System.out.println(arbol4.sonFrontera(prueba2));
        prueba2.vaciar();
        prueba3.insertar(5, 1);
        prueba3.insertar(3, 2);
        prueba3.insertar(6, 3);
        prueba3.insertar(7, 4);
        prueba3.insertar(8, 5);
        prueba3.insertar(9, 6);
        System.out.println("Prueba3: " + prueba3.toString());
        System.out.println("Probamos el metodo con prueba3, retorna false");
        System.out.println(arbol4.sonFrontera(prueba3));
        prueba3.vaciar();
        prueba4.insertar(8, 1);
        prueba4.insertar(7, 2);
        prueba4.insertar(3, 3);
        prueba4.insertar(6, 4);
        prueba4.insertar(5, 5);
        System.out.println("Prueba4: " + prueba4.toString());
        System.out.println("Probamos el metodo con prueba4, retorna true");
        System.out.println(arbol4.sonFrontera(prueba4));
        prueba4.vaciar();

        Lista hojas4 = arbol4.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol4, retorna true");
        System.out.println(arbol4.sonFrontera(hojas4) + "\n");

        System.out.println("Creo arbol5 clonando arbol4");
        ArbolGen arbol5 = arbol4.clone();
        System.out.println("Ingreso 9 como hijo de 5 en arbol5");
        arbol5.insertar(9, 5);
        System.out.println(arbol5.toString());
        System.out.println("Ingresamos las pruebas");
        System.out.println("Lista de fronteras [9,3,6,7,8]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol5.sonFrontera(prueba1));
        prueba2.insertar(6, 1);
        System.out.println("Prueba2: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba2, retorna true");
        System.out.println(arbol5.sonFrontera(prueba2));
        prueba2.vaciar();
        prueba3.insertar(9, 1);
        prueba3.insertar(3, 2);
        prueba3.insertar(6, 3);
        prueba3.insertar(7, 4);
        prueba3.insertar(8, 5);
        prueba3.insertar(10, 6);
        System.out.println("Prueba3: " + prueba3.toString());
        System.out.println("Probamos el metodo con prueba3, retorna false");
        System.out.println(arbol5.sonFrontera(prueba3));
        prueba3.vaciar();
        prueba4.insertar(3, 1);
        prueba4.insertar(9, 2);
        prueba4.insertar(7, 3);
        prueba4.insertar(6, 4);
        prueba3.insertar(8, 5);
        System.out.println("Prueba4: " + prueba4.toString());
        System.out.println("Probamos el metodo con prueba4, retorna true");
        System.out.println(arbol5.sonFrontera(prueba4));
        prueba4.vaciar();

        Lista hojas5 = arbol5.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol5, retorna true");
        System.out.println(arbol5.sonFrontera(hojas5) + "\n");

        System.out.println("Ingreso 10 como hijo de 5 en arbol5");
        arbol5.insertar(10, 5);
        System.out.println(arbol5.toString());
        System.out.println("Ingresamos las pruebas");
        System.out.println("Lista de fronteras [9,10,3,6,7,8]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol5.sonFrontera(prueba1));
        prueba2.insertar(6, 1);
        System.out.println("Prueba2: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba2, retorna true");
        System.out.println(arbol5.sonFrontera(prueba2));
        prueba2.vaciar();
        prueba3.insertar(9, 1);
        prueba3.insertar(10, 2);
        prueba3.insertar(3, 3);
        prueba3.insertar(6, 4);
        prueba3.insertar(7, 5);
        prueba3.insertar(8, 6);
        prueba3.insertar(4, 7);
        System.out.println("Prueba3: " + prueba3.toString());
        System.out.println("Probamos el metodo con prueba3, retorna false");
        System.out.println(arbol5.sonFrontera(prueba3));
        prueba3.vaciar();
        prueba4.insertar(10, 1);
        prueba4.insertar(9, 2);
        prueba4.insertar(6, 3);
        prueba4.insertar(7, 4);
        prueba4.insertar(8, 5);
        System.out.println("Prueba4: " + prueba4.toString());
        System.out.println("Probamos el metodo con prueba4, retorna true");
        System.out.println(arbol5.sonFrontera(prueba4));
        prueba4.vaciar();

        hojas5 = arbol5.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol5, retorna true");
        System.out.println(arbol5.sonFrontera(hojas5) + "\n");

        System.out.println("Ingreso 11 ocmo hijo de 3 en arbol5");
        arbol5.insertar(11, 3);
        System.out.println(arbol5.toString());
        System.out.println("Ingresamos las pruebas");
        System.out.println("Lista de fronteras [9,10,11,6,7,8]");
        System.out.println("Prueba1: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba1, retorna false");
        System.out.println(arbol5.sonFrontera(prueba1));
        prueba2.insertar(6, 1);
        System.out.println("Prueba2: " + prueba1.toString());
        System.out.println("Probamos el metodo con prueba2, retorna true");
        System.out.println(arbol5.sonFrontera(prueba2));
        prueba2.vaciar();
        prueba3.insertar(9, 1);
        prueba3.insertar(10, 2);
        prueba3.insertar(11, 3);
        prueba3.insertar(6, 4);
        prueba3.insertar(7, 5);
        prueba3.insertar(8, 6);
        prueba3.insertar(4, 7);
        System.out.println("Prueba3: " + prueba3.toString());
        System.out.println("Probamos el metodo con prueba3, retorna false");
        System.out.println(arbol5.sonFrontera(prueba3));
        prueba3.vaciar();
        prueba4.insertar(10, 1);
        prueba4.insertar(9, 2);
        prueba4.insertar(6, 3);
        prueba4.insertar(7, 4);
        prueba4.insertar(8, 5);
        prueba4.insertar(11, 6);
        System.out.println("Prueba4: " + prueba4.toString());
        System.out.println("Probamos el metodo con prueba4, retorna true");
        System.out.println(arbol5.sonFrontera(prueba4));
        prueba4.vaciar();

        hojas5 = arbol5.frontera();
        System.out.println("Probamos el metodo con la lista de hojas de arbol5, retorna true");
        System.out.println(arbol5.sonFrontera(hojas5) + "\n");
    }
}
