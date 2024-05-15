/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaAutenticacionMedico;

/**
 *
 * @author DELL
 */
//QUE HARIAS SI UN HOMBRE TE QUIERE DAR UNA PIEDRA Y EN LA OTRA MANO TRAE UNA HAMBURGUESA
//SESION CON SINGLENTON???
public class AutenticacionMedico {
    protected int idMedico;
    protected int idCita;

    public AutenticacionMedico() {
    }

    public AutenticacionMedico(int idMedico, int idCita) {
        this.idMedico = idMedico;
        this.idCita = idCita;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
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
        final AutenticacionMedico other = (AutenticacionMedico) obj;
        if (this.idMedico != other.idMedico) {
            return false;
        }
        return this.idCita == other.idCita;
    }

    @Override
    public String toString() {
        return "AutenticacionMedico{" + "idMedico=" + idMedico + ", idCita=" + idCita + '}';
    }
    
    
}
