/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaAutenticacionPaciente;

/**
 *
 * @author DELL
 */
public class AutenticacionPaciente {
    protected int idPaciente;
    protected int idCita;

    public AutenticacionPaciente() {
    }

    public AutenticacionPaciente(int idPaciente, int idCita) {
        this.idPaciente = idPaciente;
        this.idCita = idCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final AutenticacionPaciente other = (AutenticacionPaciente) obj;
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        return this.idCita == other.idCita;
    }

    @Override
    public String toString() {
        return "AutenticacionPaciente{" + "idPaciente=" + idPaciente + ", idCita=" + idCita + '}';
    }
    
}
