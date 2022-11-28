package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

import java.io.Serializable;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author 
 * 
 * Modelo de la clase Alojamiento con sus atributos
 *
 */
@Entity(name = "Alojamiento")
@Table(name = "Alojamiento")
public class Alojamiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "alojamientoId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;


	@Column(name = "latitud")
	private String latitud;

	@Column(name = "longitud")
	private String longitud;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "horarioCheckIn")
	private Time horarioCheckIn;

	@Column(name = "horarioCheckOut")
	private Time horarioCheckOut;

	@Column(name = "categoria")
	private String categoria;

	@Column(name = "servicioId")
	private Servicio servicio;

	@Column(name = "habitacionId")
	private Habitacion habitacion;

	@Column(name = "ciudadId")
	private Ciudad ciudad;

	@Column(name = "fotoId")
	private Foto foto;
	
	public Alojamiento(Long id, String nombre, String latitud, String longitud, Double precio, String descripcion,
			Time horarioCheckIn, Time horarioCheckOut, String categoria, Servicio servicio, Habitacion habitacion,
			Ciudad ciudad, Foto foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.precio = precio;
		this.descripcion = descripcion;
		this.horarioCheckIn = horarioCheckIn;
		this.horarioCheckOut = horarioCheckOut;
		this.categoria = categoria;
		this.servicio = servicio;
		this.habitacion = habitacion;
		this.ciudad = ciudad;
		this.foto = foto;
	}

	public Alojamiento() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Alojamiento [id=" + id + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", precio=" + precio + ", descripcion=" + descripcion + ", categoria=" + categoria + ", servicio="
				+ servicio + ", habitacion=" + habitacion + ", ciudad=" + ciudad + ", foto=" + foto + "]";
	}
}