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
 * Modelo de la clase Foto con sus atributos
 * 
 * @author	Mauro
 *
 */
@Entity(name = "Foto")
@Table(name = "\"Foto\"")
public class Foto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"fotoId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "url")
	private String url;

	@Column(name = "extension")
	private String extension;

	public Foto(Long id, String url, String extension) {
		super();
		this.id = id;
		this.url = url;
		this.extension = extension;

	}

	public Foto() {
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Foto
	 * 
	 */
	@Override
	public String toString() {
		return "Foto [id=" + id + ", url=" + url + ", extension=" + extension + "]";
	}
}
