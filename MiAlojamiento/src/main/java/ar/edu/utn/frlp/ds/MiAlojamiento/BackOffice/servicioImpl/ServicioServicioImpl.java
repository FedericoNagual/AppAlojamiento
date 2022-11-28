package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosServicio;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Servicio;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.ServicioRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioServicio;



public class ServicioServicioImpl implements ServicioServicio{
	@Autowired
	private ServicioRepository servicioRepository;

	/**
	 * Guarda la entity Imagen
	 * 
	 */
	@Override
	public Servicio guardarServicio(Servicio servicio) {
		return servicioRepository.saveAndFlush(servicio);
	}

	/**
	 * Busca una entity servicio por nombre
	 * 
	 * @param nombre tipo String
	 * @return List<servicio> resultado de un Find a la BD filtrado por nombre
	 */
	@Override
	public List<Servicio> buscarServicioXNombre(String nombre) {
		//Implementar metodo que devuelva todas las Imagenes por el nombre pasado
		// por parametro
		// Traer la lista, filtrarla por nombre
		List<Servicio> listaGeneral = servicioRepository.findAll();
		List<Servicio> lista = new ArrayList<Servicio>();
		
		for (int i = 0; i < listaGeneral.size(); i++) {
			if (nombre.equals(listaGeneral.get(i).getNombre())) {
				lista.add(listaGeneral.get(i));
			}
			i++;
		}
		return lista;
	}

	/**
	 * Buscar entity Servicio por Id
	 * 
	 * @param id tipo Long
	 * @return Imagen resultado del metodo findById
	 */
	@Override
	public Servicio buscarServicioXId(Long id) {
		return servicioRepository.findById(id).get();
	}

	/**
	 * Obtener DatosServicio
	 * 
	 * @return List<DatosServicio> resultado del metodo findAllProjectedBy
	 */
	@Override
	public List<DatosServicio> obtenerDatosServicio() {
		return servicioRepository.findAllProjectedBy();
	}

	/**
	 * Eliminar una entity Servicio de la BD
	 */
	@Override
	public void eliminarServicio(Long id) {
		servicioRepository.deleteById(id);
	}

	
	

}
