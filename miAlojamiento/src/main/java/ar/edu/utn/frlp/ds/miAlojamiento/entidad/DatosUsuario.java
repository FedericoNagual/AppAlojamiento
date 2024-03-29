package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author Federico
 *
 */
public interface DatosUsuario {

	Long getId();

	String getNombre();
	
	String getApellido();

	Date getFechaNacimiento();

	String getTipoDocumento();
	
	String getDni();

	Long getTelefono();
	
	Domicilio getDomicilio();

	List<Reserva> getListaReserva();

	Login getLogin();
	
	Rol getRol();

	default String getFormatoCombo() {
		// Parseos de Datos a String para imprimir
		String id = getId().toString();
		String nombre = getNombre().toString();
		String telefono = getTelefono().toString();
		String domicilio = getDomicilio().getCalle().toString();
		String fechaNacimiento = getFechaNacimiento().toString();
		String tipoDocumento = getTipoDocumento().toString();
		String dni = getDni().toString();

		return id + " ; " + nombre + " ; " + telefono + " ; " + domicilio + " ; " + fechaNacimiento + " ; "
				+ tipoDocumento + " ; " + dni;
	}
}
