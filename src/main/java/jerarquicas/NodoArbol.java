/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jerarquicas;

/**
 *
 * @author casa
 */
public class NodoArbol {
    private Object tipoElemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;
    
    public NodoArbol (Object tipoElem, NodoArbol izq, NodoArbol der){
        this.tipoElemento = tipoElem;
        this.izquierdo = izq;
        this.derecho = der;
    }
    
    public Object getElem(){
        return this.tipoElemento;
    }
    
    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }
    
    public NodoArbol getDerecho(){
        return this.derecho;
    }
    
   public void setElem (Object tipoElem){
       this.tipoElemento = tipoElem;
   }
   
   public void setIzquierdo (NodoArbol izq){
       this.izquierdo = izq;
   }
   
   public void setDerecho (NodoArbol der){
       this.derecho = der;
   }  
}
