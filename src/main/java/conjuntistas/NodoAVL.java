/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas;

/**
 *
 * @author casa
 */
public class NodoAVL {

    private Comparable elem;
    private NodoAVL izq;
    private NodoAVL der;
    private int altura;

    public NodoAVL(Comparable elem1, NodoAVL izq1, NodoAVL der1) {
        this.elem = elem1;
        this.izq = izq1;
        this.der = der1;
        this.altura = 0;
    }

    public NodoAVL(int elem1) {
        this.elem = elem1;
        this.izq = null;
        this.der = null;
        this.altura = 0;
    }

    public Comparable getElem() {
        return this.elem;
    }

    public int getAltura() {
        return this.altura;
    }

    public NodoAVL getIzq() {
        return this.izq;
    }

    public NodoAVL getDer() {
        return this.der;
    }

    public void setAltura(int alt1) {
        this.altura = alt1;
    }

    public void setElem(int elem1) {
        this.elem = elem1;
    }

    public void setIzq(NodoAVL izq1) {
        this.izq = izq1;
    }

    public void setDer(NodoAVL der1) {
        this.der = der1;
    }

    public void actualizarAltura() {
        this.altura++;
    }

    public void recalcularAltura() {
        this.setAltura(Math.max(alturaAux(this.izq), alturaAux(this.der)) + 1);
    }

    private int alturaAux(NodoAVL n) {
        int res = -1;
        if (n != null) {
            res = n.getAltura();
        }
        return res;
    }
}
