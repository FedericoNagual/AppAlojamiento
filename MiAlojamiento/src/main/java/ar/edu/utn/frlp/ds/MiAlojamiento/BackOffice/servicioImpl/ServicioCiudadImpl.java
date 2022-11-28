package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Ciudad;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatoCiudad;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.CiudadRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioCiudad;


public class ServicioCiudadImpl implements ServicioCiudad{
	@Autowired
	private CiudadRepository ciudadRepository;

	/**
	 * Guarda la entity Pais
	 * 
	 */
	@Override
	public Ciudad guardarCiudad(Ciudad provincia) {
		return ciudadRepository.saveAndFlush(provincia);
	}

	/**
	 * Busca una entity Ciudad por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Ciudad> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Ciudad> buscarCiudadXNombre(String nombre) {
		//Implementar metodo que devuelva todas las Ciudad por el nombre pasado
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

	
	

}



