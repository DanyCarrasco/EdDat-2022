/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.conjuntistas;
import conjuntistas.ArbolHeap;

/**
 *
 * @author casa
 */
public class testArbolHeap {
    public static void main(String[] args) {
        ArbolHeap arbolA = new ArbolHeap();
        System.out.println("Arbol vacio: " + arbolA.toString());
        System.out.println("Probamos recuperarCima, retorna null: "+ arbolA.recuperarCima());
        arbolA.insertar(5);
        System.out.println("Arbol A: " + arbolA.toString());
        System.out.println("Probamos recuperarCima, retorna 1: "+ arbolA.recuperarCima());
        arbolA.insertar(2);
        System.out.println("Arbol A: " + arbolA.toString());
        System.out.println("Probamos recuperarCima, retorna 1: "+ arbolA.recuperarCima());
        arbolA.insertar(1);
        System.out.println("Arbol A: " + arbolA.toString());
        System.out.println("Probamos recuperarCima, retorna 1: "+ arbolA.recuperarCima());
    }
}
