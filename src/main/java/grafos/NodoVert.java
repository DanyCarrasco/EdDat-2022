/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author casa
 */
public class NodoVert {
    //atributos
    private Object elem;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;
    
    public NodoVert(Object nuevoElem, NodoVert nuevoSig){
        elem = nuevoElem;
        sigVertice = nuevoSig;
    }
    
    public Object getElem(){
        return elem;
    }
    
    public void setElem(Object tipoElem){
        elem = tipoElem;
    }
    
    public NodoVert getSigVertice(){
    return sigVertice;
}
    public void setSigVertice(NodoVert unVertice){
        sigVertice = unVertice;
    }
    
    public NodoAdy getPrimerAdy(){
        return primerAdy;
    }
    
    public void setPrimerAdy(NodoAdy unAdy){
        primerAdy = unAdy;
    }
}
