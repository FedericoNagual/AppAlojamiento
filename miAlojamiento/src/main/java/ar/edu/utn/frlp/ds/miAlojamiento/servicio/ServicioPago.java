package ar.edu.utn.frlp.ds.miAlojamiento.servicio;

import java.util.List;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPago;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pago;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;


public interface ServicioPago {
	public Pago  guardarPago (Pago  Pago);

	public Pago  buscarPagoXId(Long id);


	public List<Pago > buscarPagoXUltimosDigitos(String nombre);
	
	public List<DatosPago > obtenerDatosPago ();

	public void eliminarPago (Long id);
	public List<Pago> buscarPagoAll();

}
