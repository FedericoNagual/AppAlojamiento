package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Modelo de la clase Reserva con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Reserva")
@Table(name = "\"Reserva\"")
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"reservaId\"", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "\"servicioPagoId\"")
	private ServicioPago servicioPago;// servicio de pago utilizado de los cuales armamos una tabla para extraerlo y elegir cual usar

	@Column(name = "fechaInicio")
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@Column(name = "fechaFin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	@ManyToOne
	@JoinColumn(name = "\"paqueteId\"")
	private Paquete paquete;
	
	@ManyToOne
	@JoinColumn(name = "\"usuarioId\"")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "\"pagoId\"")
	private Pago pago;
	
	@ManyToOne
	@JoinColumn(name = "\"estadoReservaId\"")
	private EstadoReserva estadoReserva;

	public Reserva(Long id, ServicioPago servicioPago, Date fechaInicio, Date fechaFin, Paquete paquete,
			Usuario usuario, Pago pago, EstadoReserva estadoReserva) {
		super();
		this.id = id;
		this.servicioPago = servicioPago;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.paquete = paquete;
		this.usuario = usuario;
		this.pago = pago;
		this.estadoReserva = estadoReserva;
	}

	public Reserva() {
		super();
		setPaquete(new Paquete());
		setUsuario(new Usuario());
		setPago(new Pago());
		setFechaFin(new Date());
		setFechaInicio(new Date());
		setServicioPago(new ServicioPago());
		setEstadoReserva(new EstadoReserva());
	}

	public Paquete getPaquete() {
		return paquete;
	}

	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ServicioPago getServicioPago() {
		return servicioPago;
	}

	public void setServicioPago(ServicioPago servicioPago) {
		this.servicioPago = servicioPago;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public EstadoReserva getEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(EstadoReserva estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + "]";
	}

}