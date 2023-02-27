package ar.edu.utn.frlp.ds.miAlojamiento.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import ar.edu.utn.frlp.ds.miAlojamiento.entidad.DatosPago;
import ar.edu.utn.frlp.ds.miAlojamiento.entidad.Pago;
import ar.edu.utn.frlp.ds.miAlojamiento.servicioImpl.ServicioPagoImpl;

/**
 * Clase Bean del Consulta de Pago
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Named("consultaPagoBean")
@ViewScoped
public class ConsultaPagoBean extends GenericBean {

	@Value("${consultaPago}")
	private Long id;

	private Long idSeleccionado;
	private List<DatosPago> datosCombo;
	private Pago pago;
	private Boolean aceptarListado;

	/*
	 * Elementos para la grilla, lita y elemento seleccionado
	 */
	private List<Pago> lista;
	private Pago pagoSeleccionado;

	@Autowired
	private ServicioPagoImpl servicioPago;

	/**
	 * Se llama cuando se inicia la clase ConsutaPagoBean que setea a Pago creando
	 * una nueva instancia
	 */
	@PostConstruct
	public void init() {
		setAceptarListado(Boolean.TRUE);
		setDatosCombo(servicioPago.obtenerDatosPago());
		setLista(servicioPago.buscarPagoAll());
		setIdSeleccionado(null);
		setPago(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Long getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(Long idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public List<DatosPago> getDatosCombo() {
		return datosCombo;
	}

	public void setDatosCombo(List<DatosPago> datosCombo) {
		this.datosCombo = datosCombo;
	}

	public Boolean getAceptarListado() {
		return aceptarListado;
	}

	public void setAceptarListado(Boolean aceptarListado) {
		this.aceptarListado = aceptarListado;
	}

	public List<Pago> getLista() {
		return lista;
	}

	public void setLista(List<Pago> lista) {
		this.lista = lista;
	}

	public Pago getPagoSeleccionado() {
		return pagoSeleccionado;
	}

	public void setPagoSeleccionado(Pago pagoSeleccionado) {
		this.pagoSeleccionado = pagoSeleccionado;
	}

	/**
	 * Consulta las Pagos y busca sus datos por el Id seleccionado y los muestra en
	 * la vista
	 */
	public void consultaPago() {
		if (idSeleccionado != null) {
			setPago(servicioPago.buscarPagoXId(getIdSeleccionado()));
		}
	}

	/**
	 * Habilita la grilla y muestra los datos de toda tuplas en pantalla en una
	 * grilla
	 */
	public void consultaTotalPago() {

	}

	/**
	 * Limpia los parametros para mostrar la pagina con la grilla de inicio
	 */
	public void limpiar() {
		setIdSeleccionado(null);
		setPago(null);
		setAceptarListado(Boolean.TRUE);
	}

}
