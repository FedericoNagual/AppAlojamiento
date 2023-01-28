package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

public interface DatoProvincia {
	 Long getId();

	 String getNombre();

	 Pais getPais();
	 
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String pais = getPais().toString();
			return getNombre() + " ; " + pais ;
		}
}
