package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Modelo de la clase Categoria con sus atributos
 * 
 * Sirve para marcar las estrellas del alojamiento
 * @author Federico
 *
 */
@Entity(name = "Categoria")
@Table(name = "\"Categoria\"")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"categoriaId\"", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "\"numeroEstrella\"")
	private Long numeroEstrella;

	public Categoria(Long id, Long numeroEstrella) {
		super();
		this.id = id;
		this.numeroEstrella = numeroEstrella;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroEstrella() {
		return numeroEstrella;
	}

	public void setNumeroEstrella(Long numeroEstrella) {
		this.numeroEstrella = numeroEstrella;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", numeroEstrella=" + numeroEstrella + "]";
	}

}
