package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Time;

public interface DatosRol {
	 Long getId();

	 String getDescripcion();

	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir

			String rol = getDescripcion().toString();

			return getId() + " ; " + rol;
		}

}