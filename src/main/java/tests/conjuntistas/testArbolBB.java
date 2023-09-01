/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.conjuntistas;

import conjuntistas.ArbolBB;

/**
 *
 * @author casa
 */
public class testArbolBB {

    public static void main(String[] args) {
        ArbolBB arbolA = new ArbolBB();
        arbolA.insertar(20);
        arbolA.insertar(14);
        arbolA.insertar(8);
        arbolA.insertar(1);
        arbolA.insertar(18);
        arbolA.insertar(16);
        arbolA.insertar(19);
        arbolA.insertar(44);
        arbolA.insertar(22);
        arbolA.insertar(50);
        System.out.println("ArbolA: \n" + arbolA.toString() + "\n");
        arbolA.eliminarHojasEnRango(10, 30);
        System.out.println("ArbolA: \n" + arbolA.toString());
    }
}
