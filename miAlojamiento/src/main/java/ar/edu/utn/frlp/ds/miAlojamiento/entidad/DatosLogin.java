package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

/**
 * 
 * @author Mauro
 *
 */
public interface DatosLogin {
	String getNombre();

	String getContraseña();

	default String getFormatoCombo() {
		// Parseos de Datos a String para imprimir
		String nombre = getNombre().toString();
		String contraseña = getContraseña().toString();

		return nombre + " ; " + contraseña + " ] ";
	}
}
