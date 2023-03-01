package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Ciudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoCiudad;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Domicilio;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;
import ar.edu.utn.frlp.ds.miAlojamiento.servicio.ServicioCiudad;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioCiudadImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioDomicilioImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioLoginImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaisImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioProvinciaImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioRolImpl;
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

	private Usuario usuario;
	private List<DatosPais> listaPais;
	private List<DatoProvincia> listaProvincia;
	private List<DatoCiudad> listaCiudad;
	private Domicilio domicilio;
	private Login login;
	private Pais paisSeleccionado;
	private Provincia provinciaSeleccionado;
	private Ciudad ciudadSeleccionado;
	private Rol rolSeleccionado;

	@Autowired
	private ServicioUsuarioImpl servicioUsua;
	@Autowired
	private ServicioPaisImpl servicioPais;
	@Autowired
	private ServicioProvinciaImpl servicioProv;
	@Autowired
	private ServicioCiudadImpl servicioCiudad;
	@Autowired
	private ServicioDomicilioImpl servicioDomicilioImpl;
	@Autowired
	private ServicioLoginImpl servicioLog;
	@Autowired
	private ServicioRolImpl servicioRol;

	/**
	 * Se llama cuando se inicia la clase AltaUsuarioBean que setea a la clase
	 * Usuario creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setUsuario(new Usuario());
		setDomicilio(new Domicilio());
		setLogin(new Login());
		setListaPais(servicioPais.obtenerDatosComboPais());
		setListaProvincia(servicioProv.obtenerDatosProvincia());
		setListaCiudad(servicioCiudad.obtenerDatosCiudad());
	}

	public Rol getRolSeleccionado() {
		return rolSeleccionado;
	}

	public void setRolSeleccionado(Rol rolSeleccionado) {
		this.rolSeleccionado = rolSeleccionado;
	}

	public ServicioLoginImpl getServicioLog() {
		return servicioLog;
	}

	public void setServicioLog(ServicioLoginImpl servicioLog) {
		this.servicioLog = servicioLog;
	}

	public ServicioRolImpl getServicioRol() {
		return servicioRol;
	}

	public void setServicioRol(ServicioRolImpl servicioRol) {
		this.servicioRol = servicioRol;
	}

	public Pais getPaisSeleccionado() {
		return paisSeleccionado;
	}

	public void setPaisSeleccionado(Pais paisSeleccionado) {
		this.paisSeleccionado = paisSeleccionado;
	}

	public Provincia getProvinciaSeleccionado() {
		return provinciaSeleccionado;
	}

	public void setProvinciaSeleccionado(Provincia provinciaSeleccionado) {
		this.provinciaSeleccionado = provinciaSeleccionado;
	}

	public Ciudad getCiudadSeleccionado() {
		return ciudadSeleccionado;
	}

	public void setCiudadSeleccionado(Ciudad ciudadSeleccionado) {
		this.ciudadSeleccionado = ciudadSeleccionado;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<DatosPais> getListaPais() {
		return listaPais;
	}

	public void setListaPais(List<DatosPais> listaPais) {
		this.listaPais = listaPais;
	}

	public List<DatoProvincia> getListaProvincia() {
		return listaProvincia;
	}

	public void setListaProvincia(List<DatoProvincia> listaProvincia) {
		this.listaProvincia = listaProvincia;
	}

	public List<DatoCiudad> getListaCiudad() {
		return listaCiudad;
	}

	public void setListaCiudad(List<DatoCiudad> listaCiudad) {
		this.listaCiudad = listaCiudad;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public ServicioUsuarioImpl getServicioUsua() {
		return servicioUsua;
	}

	public void setServicioUsua(ServicioUsuarioImpl servicioUsua) {
		this.servicioUsua = servicioUsua;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ServicioPaisImpl getServicioPais() {
		return servicioPais;
	}

	public void setServicioPais(ServicioPaisImpl servicioPais) {
		this.servicioPais = servicioPais;
	}

	public ServicioProvinciaImpl getServicioProv() {
		return servicioProv;
	}

	public void setServicioProv(ServicioProvinciaImpl servicioProv) {
		this.servicioProv = servicioProv;
	}

	public ServicioCiudadImpl getServicioCiudad() {
		return servicioCiudad;
	}

	public void setServicioCiudad(ServicioCiudadImpl servicioCiudad) {
		this.servicioCiudad = servicioCiudad;
	}

	public ServicioDomicilioImpl getServicioDomicilioImpl() {
		return servicioDomicilioImpl;
	}

	public void setServicioDomicilioImpl(ServicioDomicilioImpl servicioDomicilioImpl) {
		this.servicioDomicilioImpl = servicioDomicilioImpl;
	}

	/**
	 * Guarda una entity Usuario y muestra un msj con los resultados
	 */
	public void guardarUsuario() {
		// login user pass; domicilio con sus datos y elegir su ciudad; setear el rol
		// del usuario tipo 1 cliente
		domicilio.setCiudad(ciudadSeleccionado);

		try {
			Domicilio resulDomiiclio = servicioDomicilioImpl.guardarDomicilio(domicilio);

		} catch (Exception e) {
			mostrarMensajeError("Error : " + e.toString());
		}

		try {
			Login resulLogin = servicioLog.guardarLogin(login);

		} catch (Exception e) {
			mostrarMensajeError("Error : " + e.toString());
		}

		try {
			rolSeleccionado = servicioRol.buscarRolXId(new Long(1));

		} catch (Exception e) {
			mostrarMensajeError("Error : " + e.toString());
		}

		usuario.setDomicilio(domicilio);
		usuario.setRol(rolSeleccionado);
		usuario.setLogin(login);

		try {
			Usuario resultado = servicioUsua.guardarUsuario(getUsuario());
			mostrarMensaje("Se creó el usuario: " + resultado.getNombre() + " con el ID: " + resultado.getId());

		} catch (Exception e) {
			mostrarMensajeError("Error : " + e.toString());
		}
		init();
	}

}
