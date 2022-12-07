package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

/**
 * 
 * Objeto del tipo DTO para el uso de Combos de Habitacion
 * 
 * @author Federico
 * 
 */
public interface DatosHabitacion {

	// Tipo de dato, getNombreDato();
	Long getId();

	String getNombre();

	Integer getCapacidad();

	Double getPrecioNoche();

	String getDescripcion();

	Double getMonto();

	default String getFormatoCombo() {
		// Parseos de Datos a String para imprimir
		String capacidad = getCapacidad().toString();
		String precioNoche = getPrecioNoche().toString();
		String monto = getMonto().toString();
		return getNombre() + " ; " + capacidad + " ; " + precioNoche + " ; " + getDescripcion() + " ; " + monto;
	}

}
