package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.sql.Time;
import java.util.List;

public interface DatosAlojamiento {
	
	Long getId();

	String getNombre();

	String getLatitud();

	String getLongitud();

	Double getPrecio();

	String getDescripcion();

	Time getHorarioCheckIn();

	Time getHorarioCheckOut();

	String getCategoria();

	List<Servicio> getListaServicio();

	List<Habitacion> getListaHabitacion();

	Ciudad getCiudad();

	Foto getFoto();

	default String getFormatoCombo() {
		// Parseos de Datos a String para imprimir
		String servicio = getListaServicio().toString();
		String habitacion = getListaHabitacion().toString();
		String ciudad = getCiudad().toString();
		String precio = getPrecio().toString();
		String horarioCheckIn = getHorarioCheckIn().toString();
		String horarioCheckOut = getHorarioCheckOut().toString();
		String foto = getFoto().toString();

		return getNombre() + " ; " + servicio+ " ; " + habitacion + " ; " + ciudad + " ; " + getLatitud() + " ; "
				+ getLongitud() + " ; " + getDescripcion() + " ; " + precio + " ; " + horarioCheckIn + " ; "
				+ horarioCheckOut + " ; " + foto;
	}

}
