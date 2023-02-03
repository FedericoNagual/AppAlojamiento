package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.util.List;

public interface DatoProvincia {
	 Long getId();

	 String getNombre();

	 List<Ciudad> getListaCiudad();
	 
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			return getNombre() + " ; ";
		}
}
