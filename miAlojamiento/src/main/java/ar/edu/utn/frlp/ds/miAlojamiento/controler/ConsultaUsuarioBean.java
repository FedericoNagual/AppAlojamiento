package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosUsuario;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioUsuarioImpl;

/**
 * Clase Bean del Consulta de Usuario
 * 
 * @author Mauro
 *
 */
@Named("consultaUsuarioBean")
@ViewScoped
public class ConsultaUsuarioBean extends GenericBean {

	@Value("${consultaUsuario}")
	private Long id;

	private Long idSeleccionado;
	private List<DatosUsuario> datosCombo;
	private Usuario Usuario;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Usuario> lista;
	private Usuario UsuarioSeleccionado;

	@Autowired
	private ServicioUsuarioImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaUsuarioBean que setea a
	 * Usuario creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosUsuario());
		setLista(servicio.buscarUsuarioAll());
		setIdSeleccionado(null);
		setUsuario(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosUsuario> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosUsuario> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public Usuario getUsuarioSeleccionado() {
		return UsuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario UsuarioSeleccionado) {
		this.UsuarioSeleccionado = UsuarioSeleccionado;
	}

	/**
	 * Consulta las Usuarios y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaUsuario() {
		if (idSeleccionado != null) {
			setUsuario(servicio.buscarUsuarioXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalUsuario() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setUsuario(null);
		setAceptarListado(Boolean.TRUE);
	}
}

