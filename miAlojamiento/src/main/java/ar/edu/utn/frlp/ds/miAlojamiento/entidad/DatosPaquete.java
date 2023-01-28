package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

public interface DatosPaquete {
	Long getId();

	String getNombre();

	String getDescripcion();

	 Long getCantidadDias();

	 Long getCantidadNoches();

	 Imagen getImagen();

	 Alojamiento getAlojamiento();
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String alojamiento = getAlojamiento().toString();
			String cantidadDias = getCantidadDias().toString();
			String cantidadNoches = getCantidadNoches().toString();
			String imagen = getImagen().toString();
			
			return getNombre() + " ; " + getDescripcion()+ " ; " +cantidadDias+ " ; " +cantidadNoches+ " ; " +imagen+ " ; " +alojamiento ;
		}
}
