/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaExpediente;

import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Consulta {
    protected int idConsulta;
    protected String sintomas;
    protected String diagnostico;
    protected String receta;

    public Consulta() {
    }

    public Consulta(int idConsulta, String sintomas, String diagnostico, String receta) {
        this.idConsulta = idConsulta;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
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
    public int hashCode() {
        int hash = 5;
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
        final Consulta other = (Consulta) obj;
        if (this.idConsulta != other.idConsulta) {
            return false;
        }
        if (!Objects.equals(this.sintomas, other.sintomas)) {
            return false;
        }
        if (!Objects.equals(this.diagnostico, other.diagnostico)) {
            return false;
        }
        return Objects.equals(this.receta, other.receta);
    }

    @Override
    public String toString() {
        return "Consulta{" + "idConsulta=" + idConsulta + ", sintomas=" + sintomas + ", diagnostico=" + diagnostico + ", receta=" + receta + '}';
    }
    
}
