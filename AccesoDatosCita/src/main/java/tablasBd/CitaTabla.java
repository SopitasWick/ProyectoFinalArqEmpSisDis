/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package tablasBd;

import SistemaCitas.Cita;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class CitaTabla{
   protected List<Cita> listaCitasTabla;
    
    private CitaTabla() {
     this.listaCitasTabla=new ArrayList();
    }
    
    public static CitaTabla getInstance() {
        return CitaHolder.INSTANCE;
    }
    
    private static class CitaHolder {

        private static final CitaTabla INSTANCE = new CitaTabla();
    }

    public List<Cita> getListaCitasTabla() {
        return listaCitasTabla;
    }

    public void setListaCitasTabla(List<Cita> listaCitasTabla) {
        this.listaCitasTabla = listaCitasTabla;
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
        final CitaTabla other = (CitaTabla) obj;
        return Objects.equals(this.listaCitasTabla, other.listaCitasTabla);
    }

    @Override
    public String toString() {
        return "CitaTabla{" + "listaCitasTabla=" + listaCitasTabla + '}';
    }
   
}
