package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.OneToOne;


public interface DatosUsuario {

	 Long getId();	 
	 
	 String getNombre();
	 
	 Long getTelefono();

	 Rol getRol();

	 Domicilio getDomicilio();

	 Date getFechaNacimiento();

	 String getTipoDocumento();
	 
	 String getDni();

	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String id = getId().toString();
			String nombre = getNombre().toString();
			String telefono = getTelefono().toString();
			String rol = getRol().getDescripcion().toString();
			String domicilio = getDomicilio().getNombre().toString();
			String fechaNacimiento = getFechaNacimiento().toString();
			String tipoDocumento = getTipoDocumento().toString();
			String dni = getDni().toString();
			
			return  id+ " ; " +nombre+ " ; " +telefono+ " ; " +rol+ " ; " +domicilio + " ; " +fechaNacimiento + " ; " +tipoDocumento + " ; " +dni  ;
		}
}
