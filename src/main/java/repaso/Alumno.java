/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

import repaso.Direccion;

/**
 *
 * @author casa
 */
public class Alumno {

    private String legajo;
    private String nombre;
    private String apellido;
    private String tipoDni;
    private int numeroDni;
    private Direccion suDireccion;
    private int telefono;
    private String usuarioSIU;
    private String claveSIU;

    public Alumno(String unLegajo) {
        legajo = unLegajo;
    }

    public Alumno(String unLegajo, String unNombre, String unApellido, String unTipo,
            int numDni, Direccion unaDireccion, int tel, String usuario, String clave) {
        legajo = unLegajo;
        nombre = unNombre;
        apellido = unApellido;
        tipoDni = unTipo;
        numeroDni = numDni;
        suDireccion = unaDireccion;
        telefono = tel;
        usuarioSIU = usuario;
        claveSIU = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public int getNumeroDni() {
        return numeroDni;
    }

    public Direccion getDireccion() {
        return suDireccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getUsuarioSIU() {
        return usuarioSIU;
    }

    public void setNombre(String unNombre) {
        nombre = unNombre;
    }

    public void setApellido(String unApellido) {
        apellido = unApellido;
    }

    public void setTipoDni(String unTipo) {
        tipoDni = unTipo;
    }

    public void setDireccion(Direccion unaDireccion) {
        suDireccion = unaDireccion;
    }
    
    public void setTelefono(int unTelefono){
        telefono = unTelefono;
    }
    
    public void setUsuarioSIU(String unUsuario){
        usuarioSIU = unUsuario;
    }

}
