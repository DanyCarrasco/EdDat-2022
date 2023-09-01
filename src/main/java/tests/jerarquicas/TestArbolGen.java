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
        arbolA.insertar('r', 'r');
        arbolA.insertar('v', 'r');
        arbolA.insertar('s', 'r');
        arbolA.insertar('p', 's');
        arbolA.insertar('k', 's');
        arbolA.insertar('u', 'v');
        arbolA.insertar('p', 'u');
        arbolA.insertar('w', 'v');
        arbolA.insertar('x', 'w');
        arbolA.insertar('y', 'w');
        arbolA.insertar('z', 'w');
        System.out.println(arbolA.toString() + "\n");
        System.out.println("Probamos repetirHEI('v'), retorna un arbol con 'v' insertado nuevamente");
        arbolA.repetirHEI('v');
        System.out.println(arbolA.toString() + "\n");
    }
}
