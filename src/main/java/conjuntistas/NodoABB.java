/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjuntistas;

/**
 *
 * @author casa
 */
public class NodoABB {
    private Comparable tipoElemento;
    private NodoABB izquierdo;
    private NodoABB derecho;
    
    public NodoABB (Comparable tipoElem, NodoABB izq, NodoABB der){
        this.tipoElemento = tipoElem;
        this.izquierdo = izq;
        this.derecho = der;
    }
    
    public Comparable getElem(){
        return this.tipoElemento;
    }
    
    public NodoABB getIzquierdo(){
        return this.izquierdo;
    }
    
    public NodoABB getDerecho(){
        return this.derecho;
    }
    
   public void setElem (Comparable tipoElem){
       this.tipoElemento = tipoElem;
   }
   
   public void setIzquierdo (NodoABB izq){
       this.izquierdo = izq;
   }
   
   public void setDerecho (NodoABB der){
       this.derecho = der;
   }
}
