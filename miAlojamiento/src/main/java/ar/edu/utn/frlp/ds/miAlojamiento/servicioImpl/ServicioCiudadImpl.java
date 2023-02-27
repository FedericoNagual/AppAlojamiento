package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoCiudad;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.CiudadRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioCiudad;

/**
 * Implementacion del Servicio Ciudad
 * 
 * @author Mauro
 * @author Federico
 *
 */

@SessionScope
@Service
public class ServicioCiudadImpl implements ServicioCiudad {
	@Autowired
	private CiudadRepository ciudadRepository;

	/**
	 * Guarda la entity ciudad
	 * 
	 */
	@Override
	public Ciudad guardarCiudad(Ciudad ciudad) {
		return ciudadRepository.saveAndFlush(ciudad);
	}

	/**
	 * Busca una entity Ciudad por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Ciudad> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Ciudad> buscarCiudadXNombre(String nombre) {
		// Implementar metodo que devuelva todas las Ciudad por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Ciudad> listaGeneral = ciudadRepository.findAll();
		List<Ciudad> lista = new ArrayList<Ciudad>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Provincia por Id
	 * 
	 * @param id tipo Long
	 * @return Provincia resultado del metodo findById
	 */
	@Override
	public Ciudad buscarCiudadXId(Long id) {
		return ciudadRepository.findById(id).get();
	}

	/**
	 * Obtener DatosCiudad
	 * 
	 * @return List<DatosCiudad> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatoCiudad> obtenerDatosCiudad() {
		return ciudadRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Ciudad de la BD
	 */
	@Override
	public void eliminarCiudad(Long id) {
		ciudadRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Ciudad que existen
	 * 
	 * @return List<Ciudad> resultado del metodo findAll()
	 */
	@Override
	public List<Ciudad> buscarCiudadAll() {
		List<Ciudad> ListaCompleta = ciudadRepository.findAll();
		return ListaCompleta;
	}

}
