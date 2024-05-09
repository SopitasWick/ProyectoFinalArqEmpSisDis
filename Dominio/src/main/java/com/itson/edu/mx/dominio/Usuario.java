/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.edu.mx.dominio;

/**
 *
 * @author DELL
 */
public class Usuario {
    protected String nomUsuario;
    protected String password;

    public Usuario() {
    }

    public Usuario(String nomUsuario, String password) {
        this.nomUsuario = nomUsuario;
        this.password = password;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nomUsuario=" + nomUsuario + ", password=" + password + '}';
    }
    
}
