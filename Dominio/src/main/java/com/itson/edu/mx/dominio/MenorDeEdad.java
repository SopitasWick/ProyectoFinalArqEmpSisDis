/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.dominio;

/**
 *
 * @author DELL
 */
public class MenorDeEdad extends Paciente{
    protected Tutor tutor;

    public MenorDeEdad() {
    }

    public MenorDeEdad(Tutor tutor) {
        this.tutor = tutor;
    }

    public MenorDeEdad(Tutor tutor, String nombre, int edad, Expediente expediente) {
        super(nombre, edad, expediente);
        this.tutor = tutor;
    }

    public MenorDeEdad(Tutor tutor, String nombre, int edad, Expediente expediente, String nomUsuario, String password) {
        super(nombre, edad, expediente, nomUsuario, password);
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
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

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MenorDeEdad{" + "tutor=" + tutor + '}';
    }
    
}
