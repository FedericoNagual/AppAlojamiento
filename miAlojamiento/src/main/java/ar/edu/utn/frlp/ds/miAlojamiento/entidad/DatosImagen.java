package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

/**
 * 
 * @author Mauro
 *
 */
public interface DatosImagen {
	Long getId();
	 String getUrl();

	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			return getUrl()  ;
		}
}

