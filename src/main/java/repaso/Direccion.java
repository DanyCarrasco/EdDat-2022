/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

/**
 *
 * @author casa
 */
public class Direccion {
    private String calle;
    private int numero;
    private String ciudad;
    
    public Direccion (String nombreCalle, int numeroCalle, String nombreCiudad){
        calle = nombreCalle;
        numero = numeroCalle;
        ciudad = nombreCiudad;
    }
    
    public String getCalle(){
        return calle;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public String getCiudad(){
        return ciudad;
    }
    
    public void setCalle(String unaCalle){
        calle = unaCalle;
    }
    
    public void setNumero(int unNumero){
        numero = unNumero;
    }
    
    public void setCiudad(String unaCiudad){
        ciudad = unaCiudad;
    }
}
