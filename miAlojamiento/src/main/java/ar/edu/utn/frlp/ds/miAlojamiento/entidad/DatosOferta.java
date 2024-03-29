package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.util.Date;

/**
 * 
 * @author Federico
 *
 */
public interface DatosOferta {


	Long getId();

	String getNombre();

	Date getFechaInicio();

	Date getFechaFin();

	Double getDescuento();

	String getDescripcion();

	Alojamiento getAlojamiento();


	default String getFormatoCombo() {
		// Parseos de Datos a String para imprimir

		String descuento = getDescuento().toString();
		String fechaFin = getFechaFin().toString();
		String fechaInicio = getFechaInicio().toString();

		return getNombre() + " ; " + fechaInicio+ " ; " + fechaFin + " ; " + descuento + " ; " + getDescripcion() + " ; "
				+ getAlojamiento().toString() ;
	}

}
