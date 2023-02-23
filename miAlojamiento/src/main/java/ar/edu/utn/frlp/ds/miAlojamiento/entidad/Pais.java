package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Pais con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Pais")
@Table(name = "\"Pais\"")
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"paisId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "pais")
	private List<Provincia> listaProvincia;

	public Pais(Long id, String nombre, List<Provincia> listaProvincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaProvincia = listaProvincia;

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

	public List<Provincia> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<Provincia> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Pais
	 * 
	 */
	@Override
	public String toString() {
		return "Pais [id=" + id + ", nombre=" + nombre + "]";
	}

}
