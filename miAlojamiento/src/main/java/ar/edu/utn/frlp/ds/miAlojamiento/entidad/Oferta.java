package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Modelo de la clase Oferta con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Oferta")
@Table(name = "\"Oferta\"")
public class Oferta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ofertaId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "\"fechaInicio\"")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@Column(name = "\"fechaFin\"")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	@Column(name = "descuento")
	private Double descuento;

	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "\"alojamientoId\"")
	private Alojamiento alojamiento;

	public Oferta(Long id, String nombre, Date fechaInicio, Date fechaFin, Double descuento, String descripcion,Alojamiento alojamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.alojamiento= alojamiento;
	}

	public Oferta() {
		super();
		setFechaFin(new Date());
		setFechaInicio(new Date());
		setAlojamiento(new Alojamiento());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", nombre=" + nombre + ", descuento=" + descuento + ", descripcion=" + descripcion
				+ "]";
	}

}