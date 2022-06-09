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
        arbolA.insertar(1, 1);
        arbolA.insertar(2, 1);
        arbolA.insertar(3, 1);
        arbolA.insertar(4, 3);
        System.out.println(arbolA.toString()+"\n");
        
        System.out.println("Probamos clone, retorna un arbol clonado de arbolA: arbolB");
        ArbolGen arbolB = arbolA.clone();
        System.out.println(arbolB.toString()+"\n");
        
        System.out.println("Probamos padre buscando el padre de '4'");
        System.out.println(arbolA.padre(4));
        
        System.out.println("Probamos con altura con el arbolA y '4', retorna 3");
        System.out.println(arbolA.nivel(4));
        
        System.out.println("Probamos ancestros con arbolA, retorna ancestros de 4");
        System.out.println(arbolA.ancestros(4).toString());
        
        System.out.println("Probamos frontera, retorna las hojas del arbolA");
        System.out.println(arbolA.frontera().toString());
    }
}
