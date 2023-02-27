package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo de la clase Estado de la Reserva con sus atributos
 * 
 * @author Federico
 *
 */
@Entity(name = "EstadoReserva")
@Table(name = "\"EstadoReserva\"")
public class EstadoReserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"estadoReservaId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	public EstadoReserva(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public EstadoReserva() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "EstadoReserva [id=" + id + ", nombre=" + nombre + "]";
	}

}
