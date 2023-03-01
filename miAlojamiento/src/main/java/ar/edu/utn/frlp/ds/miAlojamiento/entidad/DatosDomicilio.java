package ar.edu.utn.frlp.ds.miAlojamiento.entidad;


public interface DatosDomicilio {
	 Long getId();

	 String getCalle();
	 
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir

			return getCalle() + " ]";
		}

}