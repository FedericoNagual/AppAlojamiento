package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Habitacion con sus atributos
 * 
 * @author Federico
 *
 */
@Entity(name = "Habitacion")
@Table(name = "Habitacion")
public class Habitacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "habitacionId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "capacidad")
	private Integer capacidad;

	@Column(name = "precioNoce")
	private Double precioNoche;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "monto")
	private Double monto;

	public Habitacion(Long id, String nombre, Integer capacidad, Double precioNoche, String descripcion, Double monto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.precioNoche = precioNoche;
		this.descripcion = descripcion;
		this.monto = monto;
	}

	public Habitacion() {
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

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Double getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(Double precioNoche) {
		this.precioNoche = precioNoche;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Habitacion
	 * 
	 */
	@Override
	public String toString() {
		return "Habitacion [id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", precioNoche="
				+ precioNoche + ", descripcion=" + descripcion + ", monto=" + monto + "]";
	}

}
