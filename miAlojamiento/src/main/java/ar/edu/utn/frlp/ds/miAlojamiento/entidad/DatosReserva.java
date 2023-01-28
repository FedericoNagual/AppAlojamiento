package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Date;


public interface DatosReserva {

	 String getServicio();

	 Usuario getUsuario();

	 Date getFechaInicio();

	 Date getFechaFin();

	 Pago getPago();

	 Paquete getPaquete();
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String usuario = getUsuario().toString();
			String fechaInicio = getFechaInicio().toString();
			String fechaFin = getFechaFin().toString();
			String pago = getPago().toString();
			String paquete = getPaquete().toString();
			
			return getServicio() + " ; " + usuario+ " ; " +fechaInicio+ " ; " +fechaFin+ " ; " +pago+ " ; " +paquete ;
		}
}
