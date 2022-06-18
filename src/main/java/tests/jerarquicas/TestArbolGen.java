/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.jerarquicas;

import jerarquicas.ArbolGen;
import lineales.dinamicas.Lista;

/**
 *
 * @author casa
 */
public class TestArbolGen {

    public static void main(String[] args) {
        ArbolGen arbolA = new ArbolGen();
        arbolA.insertar(20, 0);
        arbolA.insertar(13, 20);
        arbolA.insertar(54, 20);
        arbolA.insertar(15, 13);
        arbolA.insertar(12, 13);
        arbolA.insertar(11, 54);
        arbolA.insertar(27, 54);
        arbolA.insertar(4, 54);
        arbolA.insertar(17, 27);
        System.out.println(arbolA.toString() + "\n");
        Lista lis1 = new Lista();
        lis1.insertar(20, 1);
        lis1.insertar(54, 2);
        lis1.insertar(27, 3);
        System.out.println("Probar verificar camino con <20,54,27>, retorna true");
        System.out.println(arbolA.verificarCamino(lis1));
//        System.out.println("Probar listarEntreNiveles(1, 2), retorna los hijos de 1 y los hijos de 3 en inorden");
//        System.out.println(arbolA.listarEstreNiveles(1, 2).toString());
    }
}
