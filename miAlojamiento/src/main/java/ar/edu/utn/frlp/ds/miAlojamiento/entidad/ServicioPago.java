package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo de la clase Servicio de pago con sus atributos
 * 
 * @author Federico
 *
 */
@Entity(name = "ServicioPago")
@Table(name = "\"ServicioPago\"")
public class ServicioPago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"servicioPagoId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	public ServicioPago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioPago(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
		return "ServicioPago [id=" + id + ", nombre=" + nombre + "]";
	}

}
