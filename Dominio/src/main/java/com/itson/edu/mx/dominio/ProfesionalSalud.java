/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.dominio;

/**
 *
 * @author DELL
 */
public class ProfesionalSalud extends Usuario{
    protected String nombre;
    protected String cedula;
    protected String tokenHuella;

    public ProfesionalSalud() {
    }

    public ProfesionalSalud(String nombre, String cedula, String tokenHuella) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tokenHuella = tokenHuella;
    }

    public ProfesionalSalud(String nombre, String cedula, String tokenHuella, String nomUsuario, String password) {
        super(nomUsuario, password);
        this.nombre = nombre;
        this.cedula = cedula;
        this.tokenHuella = tokenHuella;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTokenHuella() {
        return tokenHuella;
    }

    public void setTokenHuella(String tokenHuella) {
        this.tokenHuella = tokenHuella;
    }

    @Override
    public String toString() {
        return "ProfesionalSalud{" + "nombre=" + nombre + ", cedula=" + cedula + ", tokenHuella=" + tokenHuella + '}';
    }
    
}
