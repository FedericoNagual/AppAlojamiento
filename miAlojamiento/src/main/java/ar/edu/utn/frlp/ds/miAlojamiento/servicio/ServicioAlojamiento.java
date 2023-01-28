package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Alojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosAlojamiento;


public interface ServicioAlojamiento {
	public Alojamiento  guardarAlojamiento (Alojamiento  alojamiento);

	public Alojamiento  buscarAlojamientoXId(Long id);


	public List<Alojamiento > buscarAlojamientoXNombre(String nombre);
	
	public	List<DatosAlojamiento > obtenerDatosAlojamiento ();

	public void eliminarAlojamiento (Long id);
	
	public List<Alojamiento> buscarAlojamientoAll();
}
