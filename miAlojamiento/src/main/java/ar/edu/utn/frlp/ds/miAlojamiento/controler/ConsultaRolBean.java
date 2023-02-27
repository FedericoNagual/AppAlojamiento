package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosRol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioRolImpl;

/**
 * Clase Bean del Consulta de Rol
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("consultaRolBean")
@ViewScoped
public class ConsultaRolBean extends GenericBean {

	@Value("${consultaRol}")
	private Long id;

	private Long idSeleccionado;
	private List<DatosRol> datosCombo;
	private Rol Rol;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Rol> lista;
	private Rol RolSeleccionado;

	@Autowired
	private ServicioRolImpl servicioRol;

	/**
	 * Se llama cuando se inicia la clase ConsutaRolBean que setea a Rol creando una
	 * nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicioRol.obtenerDatosRol());
		setLista(servicioRol.buscarRolAll());
		setIdSeleccionado(null);
		setRol(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rol getRol() {
		return Rol;
	}

	public void setRol(Rol Rol) {
		this.Rol = Rol;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosRol> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosRol> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Rol> getLista() {
		return lista;
	}

	public void setLista(List<Rol> lista) {
		this.lista = lista;
	}

	public Rol getRolSeleccionado() {
		return RolSeleccionado;
	}

	public void setRolSeleccionado(Rol RolSeleccionado) {
		this.RolSeleccionado = RolSeleccionado;
	}

	/**
	 * Consulta las Rols y busca sus datos por el Id seleccionado y los muestra en
	 * la vista
	 */
	public void consultaRol() {
		if (idSeleccionado != null) {
			setRol(servicioRol.buscarRolXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalRol() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setRol(null);
		setAceptarListado(Boolean.TRUE);
	}

}
