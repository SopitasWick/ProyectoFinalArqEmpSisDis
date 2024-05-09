/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.dominio;

/**
 *
 * @author DELL
 */
public class Consulta {
    protected String sintomas;
    protected String diagnostico;
    protected String receta;

    public Consulta() {
    }

    public Consulta(String sintomas, String diagnostico, String receta) {
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "Consulta{" + "sintomas=" + sintomas + ", diagnostico=" + diagnostico + ", receta=" + receta + '}';
    }
    
}
