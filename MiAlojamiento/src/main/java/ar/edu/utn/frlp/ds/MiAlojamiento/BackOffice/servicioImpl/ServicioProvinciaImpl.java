package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatoProvincia;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Provincia;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.ProvinciaRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioProvincia;

public class ServicioProvinciaImpl implements ServicioProvincia{
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
		//Implementar metodo que devuelva todas las Provincia por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Provincia> listaGeneral = provinciaRepository.findAll();
		List<Provincia> lista = new ArrayList<Provincia>();
		
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

	
	

}



