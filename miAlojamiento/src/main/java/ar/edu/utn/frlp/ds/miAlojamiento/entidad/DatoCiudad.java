package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.util.List;

public interface DatoCiudad {
	 Long getId();

	 String getNombre();

	 List<Provincia> getListaProvincia();
	 
	 List<Alojamiento> getListaAlojamiento();
	
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			return getNombre();
		}

}
