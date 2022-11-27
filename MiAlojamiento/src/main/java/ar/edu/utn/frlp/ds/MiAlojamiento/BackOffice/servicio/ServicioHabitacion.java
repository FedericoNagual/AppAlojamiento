package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosHabitacion;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Habitacion;

/**
 * Servicios de Habitacion
 * 
 * @author Federico
 *
 */
public interface ServicioHabitacion {

	public Habitacion guardarHabitacion(Habitacion habitacion);

	public List<Habitacion> buscarHabitacionXNombre(String nombre);

	public Habitacion buscarHabitacionXId(Long id);

	public List<DatosHabitacion> obtenerDatosComboHabitacion();

	public void eliminarHabitacion(Long id);

}
