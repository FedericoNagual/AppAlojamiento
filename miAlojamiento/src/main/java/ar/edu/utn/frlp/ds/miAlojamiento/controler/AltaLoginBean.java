package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioLoginImpl;

/**
 * Clase Bean del Alta de Login
 * 
 * @author Federico
 *
 */
@Named("altaLoginBean")
@ViewScoped
public class AltaLoginBean extends GenericBean {

	@Value("${altaLogin}")
	private String titulo;

	private Login Login;

	@Autowired
	private ServicioLoginImpl servicioLogin;

	/**
	 * Se llama cuando se inicia la clase AltaLoginBean que setea a la clase Login
	 * creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setLogin(new Login());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Login getLogin() {
		return Login;
	}

	public void setLogin(Login Login) {
		this.Login = Login;
	}

	/**
	 * Guarda una entity Login y muestra un msj con los resultados
	 */
	public void guardarLogin() {
		Login resultado = servicioLogin.guardarLogin(getLogin());
		mostrarMensaje("Se creó el Login: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
