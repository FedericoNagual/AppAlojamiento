package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Login;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Usuario;

@Named("inicioSesionBean")
@ViewScoped
public class InicioSesionBean extends GenericBean{
	
	@Value("${inicioSesion}")
	private String titulo;
	
	private List<Login> listaLogin;
	private List<Usuario> listaUsuario;
	
	

}
