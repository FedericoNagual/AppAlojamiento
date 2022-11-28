package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

public interface DatosPais {
	// Tipo de dato, getNombreDato();
		Long getId();

		String getNombre();

		default String getFormatoCombo() {
			return getNombre();
		}
}
