package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Date;
/**
 * 
 * @author Mauro
 *
 */
public interface DatosPago {
	 Long getId();

	 Double getMonto();

	 Date getFecha();
	 
	 String getCodigoBarra();
	 
	 Long getUltimosDigitos();
	 
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String monto = getMonto().toString();
			String codigoBarras = getCodigoBarra().toString();
			String ultimosDigitos = getUltimosDigitos().toString();
			String fecha = getFecha().toString();
		

			return monto + " ; " +  codigoBarras + " ; " + ultimosDigitos + " ; " + fecha ;
		}
}
