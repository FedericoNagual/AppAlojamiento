package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

public interface DatoCiudad {
	 Long getId();

	 String getNombre();

	 Provincia getProvincia();
	
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String provincia = getProvincia().toString();
			return getNombre() + " ; " + provincia ;
		}

}
