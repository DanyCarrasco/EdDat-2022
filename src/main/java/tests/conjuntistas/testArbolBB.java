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
        arbolA.insertar(56);
        arbolA.insertar(13);
        arbolA.insertar(78);
        arbolA.insertar(7);
        arbolA.insertar(24);
        arbolA.insertar(15);
        arbolA.insertar(100);
        System.out.println("ArbolA: \n"+ arbolA.toString());
        System.out.println("Pruebo clonarParteInvertida(13), retorna un arbol invertido del nodo '13'");
        ArbolBB arbolB = arbolA.clonarParteInvertida(13);
        System.out.println("ArbolB: \n"+ arbolB.toString());
        
    }
}
