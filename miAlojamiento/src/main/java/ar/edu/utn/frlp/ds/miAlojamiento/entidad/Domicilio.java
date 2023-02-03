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
 * Modelo de la clase Domicilio con sus atributos
 * 
 * @author	Mauro
 *
 */
@Entity(name = "Domicilio")
@Table(name = "Domicilio")
public class Domicilio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "domicilioId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	public Domicilio(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Domicilio() {
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

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Domicilio
	 * 
	 */
	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", nombre=" + nombre + "]";
	}
}
