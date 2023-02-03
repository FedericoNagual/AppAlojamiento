package ar.edu.utn.frlp.ds.miAlojamiento.entidad;


public interface DatosDomicilio {
	 Long getId();

	 String getNombre();
	 
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir

			return getNombre() + " ]";
		}

}