/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

/**
 *
 * @author casa
 */
public class NodoAdy {
    //atributos
    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    
    public NodoAdy(NodoVert nuevoVert, NodoAdy nuevoSig){
        vertice = nuevoVert;
        sigAdyacente = nuevoSig;
    }
    
    public NodoVert getVertice(){
        return vertice;
    }
    
    public void setVertice(NodoVert unVertice){
        vertice = unVertice;
    }
    
    public NodoAdy getSigAdyacente(){
        return sigAdyacente;
    }
    
    public void setSigAdyacente(NodoAdy unAdyacente){
        sigAdyacente = unAdyacente;
    }
}
