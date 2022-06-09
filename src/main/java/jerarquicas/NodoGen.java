/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas;

/**
 *
 * @author casa
 */
public class NodoGen {
    private Object elem;
    private NodoGen hijoIzq;
    private NodoGen hermanoDer;
    
    public NodoGen (Object tipoElem, NodoGen izq, NodoGen otroHijo){
        elem = tipoElem;
        hijoIzq = izq;
        hermanoDer = otroHijo;
    }
    
    public Object getElem(){
        return elem;
    }
    
    public NodoGen getHijoIzquierdo(){
        return hijoIzq;
    }
    
    public NodoGen getHermanoDerecho(){
        return hermanoDer;
    }
    
    public void setElem(Object tipoElem){
        elem = tipoElem;
    }
    
    public void setHijoIzquierdo (NodoGen izq){
        hijoIzq = izq;
    }
    
    public void setHermanoDerecho (NodoGen otroHijo){
        hermanoDer = otroHijo;
    }
}
