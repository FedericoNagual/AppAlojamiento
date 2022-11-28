package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosServicio;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Servicio;

public interface ServicioServicio {

	public Servicio guardarServicio(Servicio servicio);

	public Servicio buscarServicioXId(Long id);


	public List<Servicio> buscarServicioXNombre(String nombre);
	
	List<DatosServicio> obtenerDatosServicio();

	public void eliminarServicio(Long id);




}

