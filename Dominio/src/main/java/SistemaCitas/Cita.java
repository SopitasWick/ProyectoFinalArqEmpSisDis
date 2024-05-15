/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaCitas;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Cita {
    protected int idCita;
    protected Calendar fechaCita;
    protected int idMedico;
    protected int idPaciente;

    public Cita() {
    }
    
    public Cita(int idCita, Calendar fechaCita, int idMedico, int idPaciente) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Calendar getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Calendar fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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
        final Cita other = (Cita) obj;
        if (this.idCita != other.idCita) {
            return false;
        }
        if (this.idMedico != other.idMedico) {
            return false;
        }
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        return Objects.equals(this.fechaCita, other.fechaCita);
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", fechaCita=" + fechaCita + ", idMedico=" + idMedico + ", idPaciente=" + idPaciente + '}';
    }
 
}
