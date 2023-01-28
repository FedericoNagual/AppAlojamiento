package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosServicio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Servicio;


public interface ServicioServicio {

	public Servicio guardarServicio(Servicio servicio);

	public Servicio buscarServicioXId(Long id);


	public List<Servicio> buscarServicioXNombre(String nombre);
	
	List<DatosServicio> obtenerDatosServicio();

	public void eliminarServicio(Long id);


	public List<Servicio> buscarServicioAll();


}

