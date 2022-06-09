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
        arbolA.insertar(5);
        arbolA.insertar(3);
        arbolA.insertar(1);
        arbolA.insertar(2);
        arbolA.insertar(7);
        arbolA.insertar(10);
        arbolA.insertar(8);
        System.out.println("ArbolA: \n"+ arbolA.toString());
        System.out.println("Pruebo el caso 3 de eliminar, elimino el nodo '5'");
        arbolA.eliminar(5);
        System.out.println("ArbolA: \n"+ arbolA.toString());
        
    }
}
