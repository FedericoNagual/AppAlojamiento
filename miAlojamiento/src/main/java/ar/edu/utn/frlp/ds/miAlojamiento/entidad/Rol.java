package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Rol con sus atributos
 * 
 * @author Mauro
 * @author Federico
 * 
 *
 */
@Entity(name = "Rol")
@Table(name = "\"Rol\"")
public class Rol implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"rolId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "rol")
	private List<Usuario> listaUsuario;	//1 Rol puede estar en muchos usuarios

	public Rol(Long id, String descripcion, List<Usuario> listaUsuario) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.listaUsuario = listaUsuario;
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

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Rol
	 * 
	 */
	@Override
	public String toString() {
		return "Rol [id=" + id + ", descripcion=" + descripcion + "]";
	}

}