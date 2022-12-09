package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosHabitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;

/**
 * Servicios de Habitacion
 * 
 * @author Federico
 *
 */
public interface ServicioHabitacion {

	public Habitacion guardarHabitacion(Habitacion habitacion);

	public List<Habitacion> buscarHabitacionXNombre(String nombre);

	public Habitacion buscarHabitacionXId(Long habitacionId);

	public List<DatosHabitacion> obtenerDatosComboHabitacion();

	public void eliminarHabitacion(Long habitacionId);

}
