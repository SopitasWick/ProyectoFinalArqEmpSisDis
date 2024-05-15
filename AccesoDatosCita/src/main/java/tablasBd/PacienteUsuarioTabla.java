/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablasBd;

import SistemaCitas.PacienteUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public final class PacienteUsuarioTabla {
   protected List<PacienteUsuario> tablaPacienteUsuario;

    private PacienteUsuarioTabla() {
        this.tablaPacienteUsuario= new ArrayList();
    }
    
    public static PacienteUsuarioTabla getInstance(){
    return PacienteUsuarioHolder.INSTANCE;  
    }
    
    private static class PacienteUsuarioHolder {

        private static final PacienteUsuarioTabla INSTANCE = new PacienteUsuarioTabla();
    }

    public List<PacienteUsuario> getTablaPacienteUsuario() {
        return tablaPacienteUsuario;
    }

    public void setTablaPacienteUsuario(List<PacienteUsuario> tablaPacienteUsuario) {
        this.tablaPacienteUsuario = tablaPacienteUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final PacienteUsuarioTabla other = (PacienteUsuarioTabla) obj;
        return Objects.equals(this.tablaPacienteUsuario, other.tablaPacienteUsuario);
    }

    @Override
    public String toString() {
        return "PacienteUsuarioTabla{" + "tablaPacienteUsuario=" + tablaPacienteUsuario + '}';
    }
   
}
