package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPaquete;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Paquete;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.PaqueteRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioPaquete;

/**
 * Implementacion del Servicio Paquete
 * 
 * @author Mauro
 * @author Federico+
 *
 */

@SessionScope
@Service
public class ServicioPaqueteImpl implements ServicioPaquete {
	@Autowired
	private PaqueteRepository paqueteRepository;

	/**
	 * Guarda la entity Paquete
	 * 
	 */
	@Override
	public Paquete guardarPaquete(Paquete Paquete) {
		return paqueteRepository.saveAndFlush(Paquete);
	}

	/**
	 * Busca una entity Paquete por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Paquete> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Paquete> buscarPaqueteXNombre(String nombre) {
		// Implementar metodo que devuelva todas las Paquete por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Paquete> listaGeneral = paqueteRepository.findAll();
		List<Paquete> lista = new ArrayList<Paquete>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
		}
		return lista;
	}

	/**
	 * Buscar entity Paquete por Id
	 * 
	 * @param id tipo Long
	 * @return Paquete resultado del metodo findById
	 */
	@Override
	public Paquete buscarPaqueteXId(Long id) {
		return paqueteRepository.findById(id).get();
	}

	/**
	 * Obtener DatosPaquete
	 * 
	 * @return List<DatosPaquete> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosPaquete> obtenerDatosPaquete() {
		return paqueteRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Paquete de la BD
	 */
	@Override
	public void eliminarPaquete(Long id) {
		paqueteRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Provincia que existen
	 * 
	 * @return List<Paquete> resultado del metodo findAll()
	 */
	@Override
	public List<Paquete> buscarPaqueteAll() {
		List<Paquete> ListaCompleta = paqueteRepository.findAll();
		return ListaCompleta;
	}
}
