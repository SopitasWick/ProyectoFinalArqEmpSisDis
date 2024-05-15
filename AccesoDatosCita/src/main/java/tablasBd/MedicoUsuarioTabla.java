/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package tablasBd;

import SistemaCitas.MedicoUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class MedicoUsuarioTabla {
    protected List<MedicoUsuario> MedicoUsuarioTabla;
    
    private MedicoUsuarioTabla() {
        this.MedicoUsuarioTabla= new ArrayList();
    }
    
    public static MedicoUsuarioTabla getInstance() {
        return MedicoUsuarioHolder.INSTANCE;
    }
    
    private static class MedicoUsuarioHolder {

        private static final MedicoUsuarioTabla INSTANCE = new MedicoUsuarioTabla();
    }

    public List<MedicoUsuario> getMedicoUsuarioTabla() {
        return MedicoUsuarioTabla;
    }

    public void setMedicoUsuarioTabla(List<MedicoUsuario> MedicoUsuarioTabla) {
        this.MedicoUsuarioTabla = MedicoUsuarioTabla;
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
        final MedicoUsuarioTabla other = (MedicoUsuarioTabla) obj;
        return Objects.equals(this.MedicoUsuarioTabla, other.MedicoUsuarioTabla);
    }

    @Override
    public String toString() {
        return "MedicoUsuarioTabla{" + "MedicoUsuarioTabla=" + MedicoUsuarioTabla + '}';
    }
    
}
