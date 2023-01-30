package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Time;

public interface DatosDomicilio {
	 Long getId();

	 String getNombre();

	 Ciudad getCiudad();
	 
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir

			String ciudad = getCiudad().toString();

			return getNombre() + " ; " + ciudad;
		}

}