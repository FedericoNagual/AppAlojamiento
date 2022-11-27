package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.controlador;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Habitacion;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl.ServicioHabitacionImpl;
import jakarta.annotation.PostConstruct;

/**
 * 
 * @author Federico
 *
 */
@Named("altaHabitacionBean")
@ViewScoped
public class AltaHabitacionBean extends GenericBean {

	@Value("${altaHabitacion}")
	private String titulo;

	private Habitacion habitacion;

	@Autowired
	private ServicioHabitacionImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaHabitacionBean que setea a la clase
	 * Habitacion creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setHabitacion(new Habitacion());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	/**
	 * Guarda una entity Habitacion y muestra un msj con los resultados
	 */
	public void guardarPersona() {
		Habitacion resultado = servicio.guardarHabitacion(getHabitacion());
		mostrarMensaje("Se creó la Habitacion: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
