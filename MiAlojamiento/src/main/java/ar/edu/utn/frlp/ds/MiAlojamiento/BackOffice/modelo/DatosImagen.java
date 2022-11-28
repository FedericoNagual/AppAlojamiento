package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

public interface DatosImagen {
	Long getId();
	 String getUrl();

	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			return getUrl()  ;
		}
}

