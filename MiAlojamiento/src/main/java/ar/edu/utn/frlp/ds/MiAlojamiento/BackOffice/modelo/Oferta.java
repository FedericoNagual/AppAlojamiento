package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

import java.io.Serializable;

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
 * Modelo de la clase Oferta con sus atributos
 *
 */
@Entity(name = "Oferta")
@Table(name = "Oferta")
public class Oferta implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ofertaId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;


	@Column(name = "fechaInicio")
	private DateTime fechaInicio;

	@Column(name = "fechaFin")
	private DateTime fechaFin;

	@Column(name = "descuento")
	private Double descuento;

	@Column(name = "descripcion")
	private String descripcion;



	public Oferta(Long id, String nombre, DateTime fechaInicio, DateTime fechaFin, Double descuento,
			String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
		this.descripcion = descripcion;
	}
	public Oferta() {
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
	public DateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(DateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public DateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(DateTime fechaFin) {
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