package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

public interface DatosServicio {
	 Long getId();

	 String getNombre();

	 String getDescripcion();
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			
			return getNombre() + " ; " + getDescripcion() ;
		}
}
