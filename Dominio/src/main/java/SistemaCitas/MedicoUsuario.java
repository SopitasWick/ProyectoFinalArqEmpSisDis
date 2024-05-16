/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaCitas;

import java.util.Objects;

/**
 *
 * @author DELL
 */
public class MedicoUsuario {
    protected int idMedico;
    protected String nombre;
    protected String tokenHuellaMedico;

    public MedicoUsuario() {
    }

    public MedicoUsuario(int idMedico, String nombre, String tokenHuellaMedico) {
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.tokenHuellaMedico = tokenHuellaMedico;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTokenHuellaMedico() {
        return tokenHuellaMedico;
    }

    public void setTokenHuellaMedico(String tokenHuellaMedico) {
        this.tokenHuellaMedico = tokenHuellaMedico;
    }

    @Override
    public String toString() {
        return "MedicoUsuario{" + "idMedico=" + idMedico + ", nombre=" + nombre + ", tokenHuellaMedico=" + tokenHuellaMedico + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idMedico;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.tokenHuellaMedico);
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
        final MedicoUsuario other = (MedicoUsuario) obj;
        if (this.idMedico != other.idMedico) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.tokenHuellaMedico, other.tokenHuellaMedico);
    }
    
}
