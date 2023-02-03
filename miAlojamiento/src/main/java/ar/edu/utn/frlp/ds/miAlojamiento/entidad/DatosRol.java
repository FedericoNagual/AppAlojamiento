package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.util.List;

public interface DatosRol {
	 Long getId();

	 String getDescripcion();
	 
	 List<Usuario> getListaUsuario();

	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir

			String rol = getDescripcion().toString();

			return getId() + " ; " + rol;
		}

}