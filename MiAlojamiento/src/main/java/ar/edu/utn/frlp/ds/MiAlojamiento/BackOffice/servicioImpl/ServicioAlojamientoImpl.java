package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosAlojamiento;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Alojamiento;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.AlojamientoRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioAlojamiento;

public class ServicioAlojamientoImpl implements ServicioAlojamiento{
	@Autowired
	private AlojamientoRepository AlojamientoRepository;

	/**
	 * Guarda la entity Alojamiento
	 * 
	 */
	@Override
	public Alojamiento guardarAlojamiento(Alojamiento Alojamiento) {
		return AlojamientoRepository.saveAndFlush(Alojamiento);
	}

	/**
	 * Busca una entity Alojamiento por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Alojamiento> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Alojamiento> buscarAlojamientoXNombre(String nombre) {
		//Implementar metodo que devuelva todas las Alojamiento por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Alojamiento> listaGeneral = AlojamientoRepository.findAll();
		List<Alojamiento> lista = new ArrayList<Alojamiento>();
		
		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Alojamiento por Id
	 * 
	 * @param id tipo Long
	 * @return Alojamiento resultado del metodo findById
	 */
	@Override
	public Alojamiento buscarAlojamientoXId(Long id) {
		return AlojamientoRepository.findById(id).get();
	}

	/**
	 * Obtener DatosAlojamiento
	 * 
	 * @return List<DatosAlojamiento> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosAlojamiento> obtenerDatosAlojamiento() {
		return AlojamientoRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Alojamiento de la BD
	 */
	@Override
	public void eliminarAlojamiento(Long id) {
		AlojamientoRepository.deleteById(id);
	}
}
