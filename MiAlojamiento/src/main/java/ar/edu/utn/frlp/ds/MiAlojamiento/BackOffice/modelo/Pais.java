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
 * Modelo de la clase Pais con sus atributos
 *
 */
@Entity(name = "Pais")
@Table(name = "Pais")
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paisId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	

	public Pais(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	
	}

	public Pais() {
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
	 * Imprime en formato String todos los datos
	 * de la clase
	 * 
	 * @return String datos de Pais
	 * 
	 */
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre +  "]";
	}

}
