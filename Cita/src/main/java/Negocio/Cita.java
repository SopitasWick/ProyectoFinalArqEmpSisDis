/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class Cita {
    protected int idCita;
    protected Date fechaCita;
    protected String estadoCita;
    protected Profesional medico;
    protected Usuario paciente;
    protected String motivoCita;
    protected String ubicacionConsulta;
    protected String costo;
    protected boolean recordatorioConsulta;

    public Cita() {
    }

    public Cita(int idCita, Date fechaCita, String estadoCita, Profesional medico, Usuario paciente, String motivoCita, String ubicacionConsulta, String costo, boolean recordatorioConsulta) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.estadoCita = estadoCita;
        this.medico = medico;
        this.paciente = paciente;
        this.motivoCita = motivoCita;
        this.ubicacionConsulta = ubicacionConsulta;
        this.costo = costo;
        this.recordatorioConsulta = recordatorioConsulta;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public Profesional getMedico() {
        return medico;
    }

    public void setMedico(Profesional medico) {
        this.medico = medico;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public String getUbicacionConsulta() {
        return ubicacionConsulta;
    }

    public void setUbicacionConsulta(String ubicacionConsulta) {
        this.ubicacionConsulta = ubicacionConsulta;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public boolean isRecordatorioConsulta() {
        return recordatorioConsulta;
    }

    public void setRecordatorioConsulta(boolean recordatorioConsulta) {
        this.recordatorioConsulta = recordatorioConsulta;
    }

    @Override
    public String toString() {
        return "Cita{" + "idCita=" + idCita + ", fechaCita=" + fechaCita + ", estadoCita=" + estadoCita + ", medico=" + medico + ", paciente=" + paciente + ", motivoCita=" + motivoCita + ", ubicacionConsulta=" + ubicacionConsulta + ", costo=" + costo + ", recordatorioConsulta=" + recordatorioConsulta + '}';
    }
    
}
