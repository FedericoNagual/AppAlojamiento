package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosHabitacion;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Habitacion;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.HabitacionRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioHabitacion;

/**
 * Implementacion del Servicio Habitacion
 * 
 * @author Federico
 *
 */
public class ServicioHabitacionImpl implements ServicioHabitacion{
	
	@Autowired
	private HabitacionRepository habitacionRepository;

	/**
	 * Guarda la entity Habitacion
	 * 
	 * @param habitacion tipo Habitacion
	 * @return Habitacion resultado del metodo saveAndFlush
	 */
	@Override
	public Habitacion guardarHabitacion(Habitacion habitacion) {
		return habitacionRepository.saveAndFlush(habitacion);
	}

	/**
	 * Busca una entity Habitacion por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Habitacion> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Habitacion> buscarHabitacionXNombre(String nombre) {
		//Implementar metodo que devuelva todas las Habitaciones por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Habitacion> listaGeneral = habitacionRepository.findAll();
		List<Habitacion> lista = new ArrayList<Habitacion>();
		
		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Habitacion por Id
	 * 
	 * @param id tipo Long
	 * @return Habitacion resultado del metodo findById
	 */
	@Override
	public Habitacion buscarHabitacionXId(Long id) {
		return habitacionRepository.findById(id).get();
	}

	/**
	 * Obtener DatosComboHabitacion
	 * 
	 * @return List<DatosHabitacion> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosHabitacion> obtenerDatosComboHabitacion() {
		return habitacionRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Habitaicon de la BD
	 */
	@Override
	public void eliminarHabitacion(Long id) {
		habitacionRepository.deleteById(id);
	}
	
	

}
