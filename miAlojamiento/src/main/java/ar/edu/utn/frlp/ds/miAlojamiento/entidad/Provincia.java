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
 * Modelo de la clase Provincia con sus atributos
 * 
 * @author Mauro
 * 
 *
 */
@Entity(name = "Provincia")
@Table(name = "Provincia")
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "provinciaId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "ciudadId")
	private List<Ciudad> listaCiudad;

	public Provincia(Long id, String nombre, List<Ciudad> listaCiudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaCiudad = listaCiudad;
	}

	public Provincia() {
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

	public List<Ciudad> getListaCiudad() {
		return listaCiudad;
	}

	public void setListaCiudad(List<Ciudad> listaCiudad) {
		this.listaCiudad = listaCiudad;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Provincia
	 * 
	 */
	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + "]";
	}

}
