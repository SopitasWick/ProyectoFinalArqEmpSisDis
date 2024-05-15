/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import SistemaCitas.Cita;
import SistemaCitas.MedicoUsuario;
import SistemaCitas.PacienteUsuario;
import tablasBd.CitaTabla;
import tablasBd.MedicoUsuarioTabla;
import tablasBd.PacienteUsuarioTabla;


//IMPORTAR PAQUETE DEL DOMINIO
public interface IPersistencia {
  public PacienteUsuarioTabla ObtenerInstanciaPacienteU();
  public MedicoUsuarioTabla ObtenerInstanciaMedicoU();
  public CitaTabla ObtenerInstanciaCitaTabla();
  public boolean consultarUsuarioPaciente(PacienteUsuario uP);
  public boolean consultarUsuarioMedico(MedicoUsuario uM);
  public boolean generarCita(Cita cita);
}
