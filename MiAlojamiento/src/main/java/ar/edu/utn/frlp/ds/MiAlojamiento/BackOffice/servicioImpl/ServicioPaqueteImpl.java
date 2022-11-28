package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosPaquete;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Paquete;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.PaqueteRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioPaquete;

public class ServicioPaqueteImpl implements ServicioPaquete{
	@Autowired
	private PaqueteRepository PaqueteRepository;

	/**
	 * Guarda la entity Paquete
	 * 
	 */
	@Override
	public Paquete guardarPaquete(Paquete Paquete) {
		return PaqueteRepository.saveAndFlush(Paquete);
	}

	/**
	 * Busca una entity Paquete por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<Paquete> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Paquete> buscarPaqueteXNombre(String nombre) {
		//Implementar metodo que devuelva todas las Paquete por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Paquete> listaGeneral = PaqueteRepository.findAll();
		List<Paquete> lista = new ArrayList<Paquete>();
		
		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
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
		return PaqueteRepository.findById(id).get();
	}

	/**
	 * Obtener DatosPaquete
	 * 
	 * @return List<DatosPaquete> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosPaquete> obtenerDatosPaquete() {
		return PaqueteRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Paquete de la BD
	 */
	@Override
	public void eliminarPaquete(Long id) {
		PaqueteRepository.deleteById(id);
	}
}
