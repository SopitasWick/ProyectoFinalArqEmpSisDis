/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author DELL
 */
public class Usuario {
  protected int idUsuario;
  protected String nombres;
  protected String apellidos;
  protected int edad;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombres, String apellidos, int edad) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }
 
}
