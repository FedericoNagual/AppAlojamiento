package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Modelo de la clase Alojamiento con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "\"Alojamiento\"")
@Table(name = "Alojamiento")
public class Alojamiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"alojamientoId\"", unique = true, nullable = false)
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

	@Column(name = "\"horarioCheckIn\"")
	private Long horarioCheckIn;

	@Column(name = "\"horarioCheckOut\"")
	private Long horarioCheckOut;

	@Column(name = "disponible")
	private Boolean disponible;

	@ManyToOne
	@JoinColumn(name = "\"categoriaId\"")
	private Categoria categoria; // Sirve para marcar las estrellas del alojamiento

	@ManyToMany
	@JoinColumn(name = "\"servicioId\"")
	private List<Servicio> listaServicio;// muchos alojamiento puede contar con muchos servicios

	@OneToMany(mappedBy = "alojamiento")
	private List<Habitacion> listaHabitacion;// 1 alojamiento puede tener muchas habitaciones

	@ManyToOne
	@JoinColumn(name = "\"ciudadId\"")
	private Ciudad ciudad;

	@OneToOne
	@JoinColumn(name = "\"fotoId\"")
	private Foto foto;

	@OneToMany(mappedBy = "alojamiento")
	private List<Paquete> listaPaquete;// 1 alojamiento puede estar en muchos paquetes

	public Alojamiento(Long id, String nombre, String latitud, String longitud, Double precio, String descripcion,
			Long horarioCheckIn, Long horarioCheckOut, Boolean disponible, Categoria categoria,
			List<Servicio> listaServicio, List<Habitacion> listaHabitacion, Ciudad ciudad, Foto foto,
			List<Paquete> listaPaquete) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
		this.precio = precio;
		this.descripcion = descripcion;
		this.horarioCheckIn = horarioCheckIn;
		this.horarioCheckOut = horarioCheckOut;
		this.disponible = disponible;
		this.categoria = categoria;
		this.listaServicio = listaServicio;
		this.listaHabitacion = listaHabitacion;
		this.ciudad = ciudad;
		this.foto = foto;
		this.listaPaquete = listaPaquete;
	}

	public Alojamiento() {
		super();
		setCiudad(new Ciudad());
		setFoto(new Foto());
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

	public Long getHorarioCheckIn() {
		return horarioCheckIn;
	}

	public void setHorarioCheckIn(Long horarioCheckIn) {
		this.horarioCheckIn = horarioCheckIn;
	}

	public Long getHorarioCheckOut() {
		return horarioCheckOut;
	}

	public void setHorarioCheckOut(Long horarioCheckOut) {
		this.horarioCheckOut = horarioCheckOut;
	}

	public List<Servicio> getListaServicio() {
		return listaServicio;
	}

	public void setListaServicio(List<Servicio> listaServicio) {
		this.listaServicio = listaServicio;
	}

	public List<Habitacion> getListaHabitacion() {
		return listaHabitacion;
	}

	public void setListaHabitacion(List<Habitacion> listaHabitacion) {
		this.listaHabitacion = listaHabitacion;
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

	public List<Paquete> getListaPaquete() {
		return listaPaquete;
	}

	public void setListaPaquete(List<Paquete> listaPaquete) {
		this.listaPaquete = listaPaquete;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Alojamiento [id=" + id + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud=" + longitud
				+ ", precio=" + precio + ", disponible=" + disponible + ", categoria=" + categoria + "]";
	}
}