package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

import java.sql.Time;

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

	 Servicio getServicio();

	 Habitacion getHabitacion();

	 Ciudad getCiudad();

	 Foto getFoto();
	 default String getFormatoCombo() {
			// Parseos de Datos a String para imprimir
			String servicio = getServicio().toString();
			String habitacion = getHabitacion().toString();
			String ciudad = getCiudad().toString();
			String precio = getPrecio().toString();
			String horarioCheckIn = getHorarioCheckIn().toString();
			String horarioCheckOut = getHorarioCheckOut().toString();
			String foto = getFoto().toString();

			return getNombre() + " ; " + servicio + " ; " + habitacion + " ; " + ciudad + " ; " + getLatitud()+ " ; " + getLongitud()
					+ " ; " + getDescripcion() + " ; " +precio+ " ; " + horarioCheckIn + " ; " + horarioCheckOut+ " ; " + foto;
		}

}
