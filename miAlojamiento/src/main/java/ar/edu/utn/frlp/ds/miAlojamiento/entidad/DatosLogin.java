package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Date;
/**
 * 
 * @author Mauro
 *
 */
public interface DatosLogin {
	String getNombre();

	String getContraseña();

	 Usuario getUsuario();
	 
	 
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String nombre = getNombre().toString();
			String contraseña = getContraseña().toString();
			String usuario = getUsuario().getId().toString();
		

			return nombre + " ; " +  contraseña + " ; " + usuario  ;
		}
}
