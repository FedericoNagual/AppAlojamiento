package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Alojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosAlojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.AlojamientoRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioAlojamiento;

/**
 * Implementacion del Servicio Alojamiento
 * 
 * @author Mauro
 *
 */

@SessionScope
@Service
public class ServicioAlojamientoImpl implements ServicioAlojamiento{
	@Autowired
	private AlojamientoRepository alojamientoRepository;

	/**
	 * Guarda la entity Alojamiento
	 * 
	 */
	@Override
	public Alojamiento guardarAlojamiento(Alojamiento Alojamiento) {
		return alojamientoRepository.saveAndFlush(Alojamiento);
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
		List<Alojamiento> listaGeneral = alojamientoRepository.findAll();
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
		return alojamientoRepository.findById(id).get();
	}

	/**
	 * Obtener DatosAlojamiento
	 * 
	 * @return List<DatosAlojamiento> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosAlojamiento> obtenerDatosAlojamiento() {
		return alojamientoRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Alojamiento de la BD
	 */
	@Override
	public void eliminarAlojamiento(Long id) {
		alojamientoRepository.deleteById(id);
	}
	/**
	 * Busca todos las Tuplas de Alojamiento que existen
	 * @return List<Alojamiento> resultado del metodo findAll() 
	 */
	@Override
	public List<Alojamiento> buscarAlojamientoAll() {
		List<Alojamiento> ListaCompleta= alojamientoRepository.findAll();
		return ListaCompleta;
	}
}
