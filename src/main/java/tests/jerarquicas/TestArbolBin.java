/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.jerarquicas;
import jerarquicas.ArbolBin;
import lineales.dinamicas.Lista;

/**
 *
 * @author casa
 */
public class TestArbolBin {
    public static void main(String[] args) {
        ArbolBin arbol1 = new ArbolBin();
        arbol1.insertar(1, null, 'I');
        System.out.println(arbol1.toString());
        
        arbol1.insertar(2, 1, 'I');
        System.out.println(arbol1.toString());
        
        arbol1.insertar(3, 1, 'D');
        System.out.println(arbol1.toString());
        
        arbol1.insertar(4, 3, 'D');
        System.out.println(arbol1.toString());
        
        System.out.println("Creamos arbol2 clonando al arbol1 (Probamos clone())");
        ArbolBin arbol2 = arbol1.clone();
        System.out.println(arbol2.toString());
        
        System.out.println("Probamos con padre(): buscaremos el padre de 4, retorna 3");
        System.out.println(arbol1.padre(4));
        System.out.println("Probamos con padre(): buscamos el padre de 5, retorna -1");
        System.out.println(arbol1.padre(5)+"\n");
        
        System.out.println("Utilizamos el arbol2 para probar listarPreorden(), retorna una cadena de lista");
        System.out.println(arbol2.listarPreorden().toString());
        System.out.println("Utilizamos el arbol2 para probar listarInorden(), retorna una cadena de lista");
        System.out.println(arbol2.listarInorden().toString());
        System.out.println("Utilizamos el arbol2 para probar listarPosorden(), retorna una cadena de lista");
        System.out.println(arbol2.listarPosorden().toString());
        System.out.println("Utilizamos el arbol2 para probar listarPorNivel(), retorna una cadena de lista");
        System.out.println(arbol2.listarPorNiveles().toString()+"\n");
        
        System.out.println("Usuamos arbol2 para probar altura(): retorna 2");
        System.out.println(arbol2.altura()+ "\n");
        
        System.out.println("Probamos con arbol2 nivel(): buscamos el nivel de 4, retorna 3");
        System.out.println(arbol2.nivel(4));
        System.out.println("Probamos con arbol2 nivel(): buscamos el nivel de 2, retorna 1");
        System.out.println(arbol2.nivel(2));
        System.out.println("Probamos con arbol2 nivel(): buscamos el nivel de 3, retorna 1");
        System.out.println(arbol2.nivel(3)+"\n");
        
        System.out.println("Probamos frontera() con el arbol1, retorna [2,4]");
        System.out.println(arbol1.frontera().toString()+"\n");
        
        System.out.println("Probamos obtenerAcestros con arbol1, buscamos los ancestros de 4, retorna [3,1]");
        System.out.println(arbol1.obtenerAncestros(4)+"\n");
        
        System.out.println("Probamos cloneInvertido con arbol1, retorna un nuevo arbol invertido de arbol1");
        ArbolBin arbol3 = arbol1.cloneInvertido();
        System.out.println(arbol3.toString()+"\n");
        
        
        
    }
    
}
