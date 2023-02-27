package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Servicio con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Servicio")
@Table(name = "\"Servicio\"")
public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"servicioId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToMany
	@JoinColumn(name = "\"alojamientoId\"")
	private List<Alojamiento> listaAlojamiento;

	public Servicio(Long id, String nombre, String descripcion, List<Alojamiento> listaAlojamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.listaAlojamiento = listaAlojamiento;
	}

	public Servicio() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Alojamiento> getListaAlojamiento() {
		return listaAlojamiento;
	}

	public void setListaAlojamiento(List<Alojamiento> listaAlojamiento) {
		this.listaAlojamiento = listaAlojamiento;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Servicio
	 * 
	 */
	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}