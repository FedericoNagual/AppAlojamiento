package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosPago;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Pago;


public interface ServicioPago {
	public Pago  guardarPago (Pago  Pago);

	public Pago  buscarPagoXId(Long id);


	public List<Pago > buscarPagoXUltimosDigitos(String nombre);
	
	List<DatosPago > obtenerDatosPago ();

	public void eliminarPago (Long id);
}
