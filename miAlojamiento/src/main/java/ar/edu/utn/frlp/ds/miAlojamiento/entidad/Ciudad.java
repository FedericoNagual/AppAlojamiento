package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modelo de la clase Ciudad con sus atributos
 * 
 * @author Mauro
 * @author Federico
 * 
 */
@Entity(name = "Ciudad")
@Table(name = "\"Ciudad\"")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"ciudadId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(mappedBy = "ciudad")
	private List<Domicilio> listaDomicilio;
	
	@OneToMany(mappedBy = "ciudad")
	private List<Alojamiento> listaAlojamiento;

	@ManyToOne
	@JoinColumn(name = "\"provinciaId\"")
	private Provincia provincia;

	public Ciudad(Long id, String nombre, List<Domicilio> listaDomicilio, List<Alojamiento> listaAlojamiento,
			Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaDomicilio = listaDomicilio;
		this.listaAlojamiento = listaAlojamiento;
		this.provincia = provincia;
	}

	public Ciudad() {
		super();
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
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