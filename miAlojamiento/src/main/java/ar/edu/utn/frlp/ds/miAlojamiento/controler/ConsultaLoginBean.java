package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosLogin;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioLoginImpl;

/**
 * Clase Bean del Consulta de Login
 * 
 * @author Mauro
 *
 */
@Named("consultaLoginBean")
@ViewScoped
public class ConsultaLoginBean extends GenericBean {

	@Value("${consultaLogin}")
	private Long id;

	private Long idSeleccionado;
	private List<DatosLogin> datosCombo;
	private Login Login;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Login> lista;
	private Login LoginSeleccionado;

	@Autowired
	private ServicioLoginImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaLoginBean que setea a
	 * Login creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosLogin());
		setLista(servicio.buscarLoginAll());
		setIdSeleccionado(null);
		setLogin(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Login getLogin() {
		return Login;
	}

	public void setLogin(Login Login) {
		this.Login = Login;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosLogin> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosLogin> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Login> getLista() {
		return lista;
	}

	public void setLista(List<Login> lista) {
		this.lista = lista;
	}

	public Login getLoginSeleccionado() {
		return LoginSeleccionado;
	}

	public void setLoginSeleccionado(Login LoginSeleccionado) {
		this.LoginSeleccionado = LoginSeleccionado;
	}

	/**
	 * Consulta las Logins y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaLogin() {
		if (idSeleccionado != null) {
			setLogin(servicio.buscarLoginXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalLogin() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setLogin(null);
		setAceptarListado(Boolean.TRUE);
	}

}