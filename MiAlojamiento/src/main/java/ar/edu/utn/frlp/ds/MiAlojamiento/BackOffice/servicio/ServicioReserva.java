package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosReserva;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Reserva;

public interface ServicioReserva {

	public Reserva guardarReserva(Reserva reserva);

	public Reserva buscarReservaXId(Long id);


	public List<Reserva> buscarReservaXFechaInicio(String fechaInicio);
	
	List<DatosReserva> obtenerDatosReserva();

	public void eliminarReserva(Long id);




}
