package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatoProvincia;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pais;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Provincia;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioProvinciaImpl;


/**
 * Implementacion del Servicio Provincia
 * 
 * @author Mauro
 *
 */
@Named("consultaProvinciaBean")
@ViewScoped
public class ConsultaProvinciaBean extends GenericBean{
	@Value("${consultaProvincia}")
	private String name;
	private Pais pais;
	private Long idSeleccionado;
	private List<DatoProvincia> datosCombo;
	private Provincia provincia;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Provincia> lista;
	private Provincia provinciaSeleccionada;

	@Autowired
	private ServicioProvinciaImpl servicio;

	/**
	 * Se llama cuando se inicia la clase ConsutaProvinciaBean que setea a
	 * Provincia creando una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicio.obtenerDatosProvincia());
		setLista(servicio.buscarProvinciaAll());
		setIdSeleccionado(null);
		setProvincia(null);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatoProvincia> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatoProvincia> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Provincia> getLista() {
		return lista;
	}

	public void setLista(List<Provincia> lista) {
		this.lista = lista;
	}

	public Provincia  getProvinciaSeleccionada() {
		return provinciaSeleccionada;
	}

	public void setProvinciaSeleccionada(Provincia provinciaSeleccionada) {
		this.provinciaSeleccionada = provinciaSeleccionada;
	}

	/**
	 * Consulta las provincias y busca sus datos por el Id seleccionado y los
	 * muestra en la vista
	 */
	public void consultaProvincia() {
		if (idSeleccionado != null) {
			setProvincia(servicio.buscarProvinciaXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalProvincia() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setProvincia(null);
		setAceptarListado(Boolean.TRUE);
	}
}
