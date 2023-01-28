package ar.edu.utn.frlp.ds.miAlojamiento.controler;


import java.sql.Time;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Alojamiento;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Foto;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Habitacion;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Servicio;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioAlojamientoImpl;


/**
 * 
 * @author Mauro
 *
 */
@Named("altaAlojamientoBean")
@ViewScoped
public class AltaAlojamientoBean extends GenericBean {
	@Value("${altaAlojamiento}")
	private String nombre;
	private String latitud;	
	private String longitud;
	private Double precio;
	private String descripcion;
	private Time horarioCheckIn;
	private Time horarioCheckOut;
	private String categoria;
	private Servicio servicio;
	private Habitacion habitacion;
	private Foto foto;
	private Ciudad ciudad;
	private Alojamiento alojamiento;

	@Autowired
	private ServicioAlojamientoImpl servicioI;

	/**
	 * Se llama cuando se inicia la clase AltaAlojamientoBean que setea a la clase
	 * Alojamiento creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAlojamiento(new Alojamiento());
	}
	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Time getHorarioCheckIn() {
		return horarioCheckIn;
	}

	public void setHorarioCheckIn(Time horarioCheckIn) {
		this.horarioCheckIn = horarioCheckIn;
	}

	public Time getHorarioCheckOut() {
		return horarioCheckOut;
	}

	public void setHorarioCheckOut(Time horarioCheckOut) {
		this.horarioCheckOut = horarioCheckOut;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	/**
	 * Guarda una entity Alojamiento y muestra un msj con los resultados
	 */
	public void guardarAlojamiento() {
		Alojamiento resultado = servicioI.guardarAlojamiento(getAlojamiento());
		mostrarMensaje("Se creó el Alojamiento: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
