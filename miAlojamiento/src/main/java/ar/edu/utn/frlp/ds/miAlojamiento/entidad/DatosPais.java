package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

/**
 * 
 * @author Mauro
 *
 */
public interface DatosPais {
	// Tipo de dato, getNombreDato();
		Long getId();

		String getNombre();

		default String getFormatoCombo() {
			return getNombre();
		}
}

