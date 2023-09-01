/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests.lineales;

import lineales.dinamicas.Cola;


/**
 *
 * @author casa
 */
public class TestCola {

    public static void main(String[] args) {
        Cola c1 = new Cola();
        c1.poner('A');
        c1.poner('B');
        c1.poner('C');
        c1.poner('B');
        c1.poner('A');
        c1.poner('$');
        c1.poner('C');
        c1.poner('D');
        c1.poner('D');
        c1.poner('E');
        c1.poner('$');
        c1.poner('A');
        c1.poner('F');
        c1.poner('C');
        c1.poner('C');
        c1.poner('F');
        c1.poner('A');
        System.out.println(c1.toString());
    }
}
