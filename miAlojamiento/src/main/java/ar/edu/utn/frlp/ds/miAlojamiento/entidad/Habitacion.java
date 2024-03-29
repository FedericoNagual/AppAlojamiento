package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Habitacion con sus atributos
 * 
 * @author Federico
 *
 */
@Entity(name = "Habitacion")
@Table(name = "\"Habitacion\"")
public class Habitacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"habitacionId\"", unique = true, nullable = false)
	private Long habitacionId;

	@Column(name = "nombre", nullable = false, length = 80)
	private String nombre;

	@Column(name = "capacidad", nullable = false, length = 80)
	private Integer capacidad;

	@Column(name = "\"precioNoche\"", nullable = false, length = 10)
	private Double precioNoche;

	@Column(name = "descripcion", nullable = false, length = 80)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "\"alojamientoId\"")
	private Alojamiento alojamiento;

	public Habitacion(Long habitacionId, String nombre, Integer capacidad, Double precioNoche, String descripcion,
			Alojamiento alojamiento) {
		super();
		this.habitacionId = habitacionId;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.precioNoche = precioNoche;
		this.descripcion = descripcion;
		this.alojamiento = alojamiento;
	}

	public Habitacion() {
		super();
		setAlojamiento(new Alojamiento());
	}

	public Long getHabitacionId() {
		return habitacionId;
	}

	public void setHabitacionId(Long habitacionId) {
		this.habitacionId = habitacionId;
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

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Habitacion
	 * 
	 */
	@Override
	public String toString() {
		return "Habitacion [id=" + habitacionId + ", nombre=" + nombre + ", capacidad=" + capacidad + ", precioNoche="
				+ precioNoche + ", descripcion=" + descripcion + " ]";
	}

}
