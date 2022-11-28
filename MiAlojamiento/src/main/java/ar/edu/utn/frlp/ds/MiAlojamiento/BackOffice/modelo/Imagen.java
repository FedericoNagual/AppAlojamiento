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
 * Modelo de la clase Imagen con sus atributos
 *
 */
@Entity(name = "Imagen")
@Table(name = "Imagen")
public class Imagen implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "imagenId", unique = true, nullable = false)
	private Long id;

	@Column(name = "url")
	private String url;



	public Imagen(Long id, String url) {
		super();
		this.id = id;
		this.url = url;
	}

	public Imagen() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Imagen [id=" + id + ", url=" + url + "]";
	}




}