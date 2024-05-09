/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.dominio;

/**
 *
 * @author DELL
 */
public class Paciente extends Usuario{
    protected String nombre;
    protected int edad;
    protected Expediente expediente;

    public Paciente() {
    }

    public Paciente(String nombre, int edad, Expediente expediente) {
        this.nombre = nombre;
        this.edad = edad;
        this.expediente = expediente;
    }

    public Paciente(String nombre, int edad, Expediente expediente, String nomUsuario, String password) {
        super(nomUsuario, password);
        this.nombre = nombre;
        this.edad = edad;
        this.expediente = expediente;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", edad=" + edad + ", expediente=" + expediente + '}';
    }
    
}
