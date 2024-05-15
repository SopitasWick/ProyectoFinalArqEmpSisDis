/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import SistemaCitas.Cita;
import SistemaCitas.MedicoUsuario;
import SistemaCitas.PacienteUsuario;
import interfaces.IPersistencia;
import java.util.Date;
import tablasBd.CitaTabla;
import tablasBd.MedicoUsuarioTabla;
import tablasBd.PacienteUsuarioTabla;

/**
 *
 * @author DELL
 */
public class Persistencia implements IPersistencia{
protected PacienteUsuarioTabla singlentonUsuarioPTabla;
protected MedicoUsuarioTabla singlentonUsuarioMTabla;
protected CitaTabla singlentonCitaTabla;

    public Persistencia() {
      this.singlentonUsuarioPTabla = PacienteUsuarioTabla.getInstance();
      this.singlentonUsuarioMTabla = MedicoUsuarioTabla.getInstance();
      this.singlentonCitaTabla = CitaTabla.getInstance();
    }

    public PacienteUsuarioTabla getSinglentonUsuarioPTabla() {
        return singlentonUsuarioPTabla;
    }

    public MedicoUsuarioTabla getSinglentonUsuarioMTabla() {
        return singlentonUsuarioMTabla;
    }

    public CitaTabla getSinglentonCitaTabla() {
        return singlentonCitaTabla;
    }

    @Override
    public PacienteUsuarioTabla ObtenerInstanciaPacienteU() {
       return this.getSinglentonUsuarioPTabla();
    }
    @Override
    public MedicoUsuarioTabla ObtenerInstanciaMedicoU() {
        return this.getSinglentonUsuarioMTabla();
    }

    @Override
    public CitaTabla ObtenerInstanciaCitaTabla() {
        return this.getSinglentonCitaTabla();
    }
    @Override
    public boolean consultarUsuarioPaciente(PacienteUsuario uP) {
        return this.ObtenerInstanciaPacienteU().getTablaPacienteUsuario().contains(uP);
    }

    @Override
    public boolean consultarUsuarioMedico(MedicoUsuario uM) {
        return this.ObtenerInstanciaMedicoU().getMedicoUsuarioTabla().contains(uM);
    }

    @Override
    public boolean generarCita(Cita cita) {
        if(this.ObtenerInstanciaCitaTabla().getListaCitasTabla().contains(cita)){
            return false;
        }else{
            this.ObtenerInstanciaCitaTabla().getListaCitasTabla().add(cita);
            return true;
        }    
    }
    
}
