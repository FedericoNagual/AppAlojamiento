package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Date;
import java.util.List;


public interface DatosReserva {
	
	Long getId();
	
	String getServicio();
	
	Date getFechaInicio();
	
	Date getFechaFin();
	
	List<Paquete> getListaPaquete();
	 
	default String getFormatoCombo() {
		// Parseos de Datos a String para imprimir
		String fechaInicio = getFechaInicio().toString();
		String fechaFin = getFechaFin().toString();
		
		return getServicio() + " ; " +fechaInicio+ " ; " +fechaFin+ " ; ";
	}
}
