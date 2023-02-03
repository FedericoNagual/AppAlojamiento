package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

/**
 * 
 * @author Mauro
 *
 */
public interface DatosFoto {
	Long getId();

	String getUrl();

	String getExtension();

	default String getFormatoCombo() {
		// Parseos de Datos a String para imprimir
		return getUrl() + " ; " + getExtension();
	}
}
