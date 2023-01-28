package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosReserva;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Reserva;


public interface ServicioReserva {

	public Reserva guardarReserva(Reserva reserva);

	public Reserva buscarReservaXId(Long id);


	public List<Reserva> buscarReservaXFechaInicio(String fechaInicio);
	
	public List<DatosReserva> obtenerDatosReserva();

	public void eliminarReserva(Long id);

	public List<Reserva> buscarReservaAll();


}
