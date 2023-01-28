package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPaquete;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Paquete;


public interface ServicioPaquete {

	public Paquete guardarPaquete(Paquete paquete);

	public Paquete buscarPaqueteXId(Long id);


	public List<Paquete> buscarPaqueteXNombre(String nombre);
	
	List<DatosPaquete> obtenerDatosPaquete();

	public void eliminarPaquete(Long id);

	
	public List<Paquete> buscarPaqueteAll();


}
