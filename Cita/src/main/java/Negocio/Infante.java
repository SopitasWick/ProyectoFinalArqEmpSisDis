/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author DELL
 */
public class Infante extends Usuario{
    protected Tutor tutor;

    public Infante() {
    }

    public Infante(Tutor tutor) {
        super();
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
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
        return "Infante{" + "tutor=" + tutor + '}';
    }
    
}
