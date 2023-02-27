package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioUsuarioImpl;

/**
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("altaUsuarioBean")
@ViewScoped
public class AltaUsuarioBean extends GenericBean {

	@Value("${altaUsuario}")
	private String titulo;

	private Usuario Usuario;

	@Autowired
	private ServicioUsuarioImpl servicioUsua;

	/**
	 * Se llama cuando se inicia la clase AltaUsuarioBean que setea a la clase
	 * Usuario creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setUsuario(new Usuario());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	/**
	 * Guarda una entity Usuario y muestra un msj con los resultados
	 */
	public void guardarUsuario() {
		Usuario resultado = servicioUsua.guardarUsuario(getUsuario());
		mostrarMensaje("Se creó el usuario: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
