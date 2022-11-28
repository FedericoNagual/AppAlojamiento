package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Alojamiento;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosAlojamiento;

public interface ServicioAlojamiento {
	public Alojamiento  guardarAlojamiento (Alojamiento  alojamiento);

	public Alojamiento  buscarAlojamientoXId(Long id);


	public List<Alojamiento > buscarAlojamientoXNombre(String nombre);
	
	List<DatosAlojamiento > obtenerDatosAlojamiento ();

	public void eliminarAlojamiento (Long id);
}
