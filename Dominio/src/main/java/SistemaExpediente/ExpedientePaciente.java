/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaExpediente;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class ExpedientePaciente {
  protected int idExpediente;
  protected List<Consulta> listaConsultas;

    public ExpedientePaciente() {
    }

    public ExpedientePaciente(int idExpediente, List<Consulta> listaConsultas) {
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
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExpedientePaciente other = (ExpedientePaciente) obj;
        if (this.idExpediente != other.idExpediente) {
            return false;
        }
        return Objects.equals(this.listaConsultas, other.listaConsultas);
    }

    @Override
    public String toString() {
        return "ExpedientePaciente{" + "idExpediente=" + idExpediente + ", listaConsultas=" + listaConsultas + '}';
    }
  
  
}
