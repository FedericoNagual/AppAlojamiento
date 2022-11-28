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
 * Modelo de la clase Login con sus atributos
 *
 */
@Entity(name = "Login")
@Table(name = "Login")
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loginId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;


	@Column(name = "contraseña")
	private String contraseña;

	@Column(name = "usuarioId")
	private Usuario usuario;

	

	public Login(Long id, String nombre, String contraseña, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.usuario = usuario;
	}
	public Login() {
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
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", nombre=" + nombre + ", contraseña=" + contraseña + ", usuario=" + usuario + "]";
	}
	
	

	
}