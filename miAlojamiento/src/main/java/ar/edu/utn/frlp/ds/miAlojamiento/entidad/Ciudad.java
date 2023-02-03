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
 * Modelo de la clase Ciudad con sus atributos
 * 
 * @author Mauro
 * 
 */
@Entity(name = "Ciudad")
@Table(name = "Ciudad")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ciudadId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	@JoinColumn(name = "domicilioId")
	private List<Domicilio> listaDomicilio;
	
	@OneToMany
	@JoinColumn(name = "alojamientoId")
	private List<Alojamiento> listaAlojamiento;

	public Ciudad(Long id, String nombre, List<Domicilio> listaDomicilio, List<Alojamiento> listaAlojamiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaDomicilio = listaDomicilio;
		this.listaAlojamiento = listaAlojamiento;
	}

	public Ciudad() {
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

	public List<Domicilio> getListaDomicilio() {
		return listaDomicilio;
	}

	public void setListaDomicilio(List<Domicilio> listaDomicilio) {
		this.listaDomicilio = listaDomicilio;
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
	 * @return String datos de Ciudad
	 * 
	 */
	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + "]";
	}

}