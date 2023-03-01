package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Rol;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioLoginImpl;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioUsuarioImpl;

@Named("inicioSesionBean")
@ViewScoped
public class InicioSesionBean extends GenericBean {

	@Value("${inicioSesion}")
	private String titulo;
	private Login login;
	private Rol rol;
	Boolean cliente;
	private String ruta="/formulario/";

	private List<Login> listaLogin;
	private List<Usuario> listaUsuario;

	@Autowired
	private ServicioLoginImpl servicioLogin;
	@Autowired
	private ServicioUsuarioImpl servicioUsuario;

	@PostConstruct
	public void init() {
		setLogin(new Login());
		setRol(new Rol());
		setCliente(true);
		setListaLogin(servicioLogin.buscarLoginAll());
		setListaUsuario(servicioUsuario.buscarUsuarioAll());
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Login> getListaLogin() {
		return listaLogin;
	}

	public void setListaLogin(List<Login> listaLogin) {
		this.listaLogin = listaLogin;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public ServicioLoginImpl getServicioLogin() {
		return servicioLogin;
	}

	public void setServicioLogin(ServicioLoginImpl servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

	public ServicioUsuarioImpl getServicioUsuario() {
		return servicioUsuario;
	}

	public void setServicioUsuario(ServicioUsuarioImpl servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Boolean getCliente() {
		return cliente;
	}

	public void setCliente(Boolean cliente) {
		this.cliente = cliente;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String iniciarSesion() {
		List<Login> listaGeneral = listaLogin;
		Login loginEncontrado = new Login();
		Boolean cumple = false;

		if (login.getNombre() == null || login.getContraseña() == null) {
			mostrarMensajeError("El usuario y/o la contraseña estan mal");
			
		}else {

			for (int i = 0; i < listaGeneral.size(); i++) {
				if (listaGeneral.get(i).getNombre().equals(login.getNombre())) {
					if (listaGeneral.get(i).getContraseña().equals(login.getContraseña())) {
						loginEncontrado = listaGeneral.get(i);
						cumple = true;
					}
				}
			}

			if (cumple) {
				// iniciar sesion depende el cliente
				cliente = true;
				List<Usuario> listaUsuariosGeneral = listaUsuario;
				String rolUsuario = "";
				for (int i = 0; i < listaUsuariosGeneral.size(); i++) {
					if (listaUsuariosGeneral.get(i).getLogin().getNombre().equals(loginEncontrado.getNombre())
							&& listaUsuariosGeneral.get(i).getLogin().getContraseña()
									.equals(loginEncontrado.getContraseña())) {
						rolUsuario = listaUsuariosGeneral.get(i).getRol().getDescripcion();
						this.rol = listaUsuariosGeneral.get(i).getRol();
					}
				}

				if (rolUsuario != null && rol.getId()== 2) {
					cliente = false;
				}
			}

			if (cliente) {
				// ir a la pagina pagefront
				ruta+="";
				
			} else {
				// ir a la pagina pageback
				ruta+="pageback";
			}
		}
		return ruta;
	}

}
