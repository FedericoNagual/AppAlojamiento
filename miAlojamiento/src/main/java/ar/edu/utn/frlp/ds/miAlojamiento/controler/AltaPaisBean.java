package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPaisImpl;

@Named("altaPaisBean")
@ViewScoped
public class AltaPaisBean extends GenericBean {

	@Value("${altaPais}")
	private String titulo;

	private Pais pais;

	@Autowired
	private ServicioPaisImpl servicioPais;

	@PostConstruct
	public void init() {
		setPais(new Pais());
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * Guarda una entity Pais y muestra un msj con los resultados
	 */
	public void guardarPais() {
		Pais resultado = servicioPais.guardarPais(getPais());
		mostrarMensaje("Se creó el Pais: " + resultado.getNombre() + " con el ID: " + resultado.getId());
		init();
	}

}
