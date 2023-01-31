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
 *
 */
@Named("altaUsuarioBean")
@ViewScoped
public class AltaUsuarioBean extends GenericBean {

	@Value("${altaUsuario}")
	private String nombre;

	private Usuario Usuario;

	@Autowired
	private ServicioUsuarioImpl servicio;

	/**
	 * Se llama cuando se inicia la clase AltaUsuarioBean que setea a la clase
	 * Usuario creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setUsuario(new Usuario());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		Usuario resultado = servicio.guardarUsuario(getUsuario());
		mostrarMensaje("Se creó el usuario: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
