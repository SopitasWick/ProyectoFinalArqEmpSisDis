/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author DELL
 */
public class Profesional extends Usuario{
  protected  int idProfesional;
  protected String especialidad;
  protected String cedulaProfesional;
  protected String huella;

    public Profesional() {
    }

    public Profesional(int idProfesional, String especialidad, String cedulaProfesional, String huella, int idUsuario, String nombres, String apellidos, int edad) {
        super(idUsuario, nombres, apellidos, edad);
        this.idProfesional = idProfesional;
        this.especialidad = especialidad;
        this.cedulaProfesional = cedulaProfesional;
        this.huella = huella;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    public String getHuella() {
        return huella;
    }

    public void setHuella(String huella) {
        this.huella = huella;
    }

  @Override
    public int getIdUsuario() {
        return idUsuario;
    }

  @Override
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

  @Override
    public String getNombres() {
        return nombres;
    }

  @Override
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

  @Override
    public String getApellidos() {
        return apellidos;
    }

  @Override
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

  @Override
    public int getEdad() {
        return edad;
    }

  @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Profesional{" + "idProfesional=" + idProfesional + ", especialidad=" + especialidad + ", cedulaProfesional=" + cedulaProfesional + ", huella=" + huella + '}';
    }
    
}
