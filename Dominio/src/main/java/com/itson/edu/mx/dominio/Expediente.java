/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.dominio;

import java.util.List;

/**
 *
 * @author DELL
 */
public class Expediente {
    protected int idExpediente;
    protected List<Consulta> listaConsultas;

    public Expediente() {
    }

    public Expediente(int idExpediente, List<Consulta> listaConsultas) {
        this.idExpediente = idExpediente;
        this.listaConsultas = listaConsultas;
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public List<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(List<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }

    @Override
    public String toString() {
        return "Expediente{" + "idExpediente=" + idExpediente + ", listaConsultas=" + listaConsultas + '}';
    }
    
}
