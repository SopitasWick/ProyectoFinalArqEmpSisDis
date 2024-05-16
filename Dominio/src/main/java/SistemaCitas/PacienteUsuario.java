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
public class PacienteUsuario {
   protected int idPaciente;
   protected String nombreUsuario;
   protected String tokenHuellaUsuario;

    public PacienteUsuario() {
    }

    public PacienteUsuario(int idPaciente, String nombreUsuario, String tokenHuellaUsuario) {
        this.idPaciente = idPaciente;
        this.nombreUsuario = nombreUsuario;
        this.tokenHuellaUsuario = tokenHuellaUsuario;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTokenHuellaUsuario() {
        return tokenHuellaUsuario;
    }

    public void setTokenHuellaUsuario(String tokenHuellaUsuario) {
        this.tokenHuellaUsuario = tokenHuellaUsuario;
    }

    @Override
    public String toString() {
        return "PacienteUsuario{" + "idPaciente=" + idPaciente + ", nombreUsuario=" + nombreUsuario + ", tokenHuellaUsuario=" + tokenHuellaUsuario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.idPaciente;
        hash = 43 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 43 * hash + Objects.hashCode(this.tokenHuellaUsuario);
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
        final PacienteUsuario other = (PacienteUsuario) obj;
        if (this.idPaciente != other.idPaciente) {
            return false;
        }
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        return Objects.equals(this.tokenHuellaUsuario, other.tokenHuellaUsuario);
    }
   
}
