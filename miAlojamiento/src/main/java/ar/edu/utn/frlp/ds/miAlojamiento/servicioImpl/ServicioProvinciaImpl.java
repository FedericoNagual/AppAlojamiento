package ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.repositorio.ProvinciaRepository;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioProvincia;

/**
 * Implementacion del Servicio Provincia
 * 
 * @author Mauro
 * @author Federico
 *
 */

@SessionScope
@Service
public class ServicioProvinciaImpl implements ServicioProvincia {
	@Autowired
	private ProvinciaRepository provinciaRepository;

	/**
	 * Guarda la entity Provincia
	 * 
	 */
	@Override
	public Provincia guardarProvincia(Provincia provincia) {
		return provinciaRepository.saveAndFlush(provincia);
	}

	/**
	 * Busca una entity Provincia por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Pais> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Provincia> buscarProvinciaXNombre(String nombre) {
		// Implementar metodo que devuelva todas las Provincia por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Provincia> listaGeneral = provinciaRepository.findAll();
		List<Provincia> lista = new ArrayList<Provincia>();

		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
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
	public Provincia buscarProvinciaXId(Long id) {
		return provinciaRepository.findById(id).get();
	}

	/**
	 * Obtener DatosProvincia
	 * 
	 * @return List<DatosProvincia> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatoProvincia> obtenerDatosProvincia() {
		return provinciaRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Provincia de la BD
	 */
	@Override
	public void eliminarProvincia(Long id) {
		provinciaRepository.deleteById(id);
	}

	/**
	 * Busca todos las Tuplas de Provincia que existen
	 * 
	 * @return List<Provincia> resultado del metodo findAll()
	 */
	@Override
	public List<Provincia> buscarProvinciaAll() {
		List<Provincia> ListaCompleta = provinciaRepository.findAll();
		return ListaCompleta;
	}

}
