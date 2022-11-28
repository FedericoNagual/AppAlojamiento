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
 * Modelo de la clase Rol con sus atributos
 *
 */
@Entity(name = "Rol")
@Table(name = "Rol")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rolId", unique = true, nullable = false)
	private Long id;

	@Column(name = "descripcion")
	private String descripcion;


	
	public Rol(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Rol() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	/**
	 * Imprime en formato String todos los datos
	 * de la clase
	 * 
	 * @return String datos de Rol
	 * 
	 */
	@Override
	public String toString() {
		return "Rol [id=" + id + ", descripcion=" + descripcion +  "]";
	}

}