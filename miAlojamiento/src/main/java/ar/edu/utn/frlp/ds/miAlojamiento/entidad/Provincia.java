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
 * 
 * Modelo de la clase Provincia con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Provincia")
@Table(name = "\"Provincia\"")
public class Provincia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="\"provinciaId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "\"paisId\"")
//	@JsonProperty(access= Access.WRITE_ONLY)
	@ManyToOne
	@JoinColumn(name = "\"paisId\"")
	private Pais pais;

	@OneToMany(mappedBy = "provincia")
	private List<Ciudad> listaCiudad;


	public Provincia() {
		super();
		setPais(new Pais());
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
