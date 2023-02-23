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

	@Column(name = "servicio")
	private String servicio;

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

	public Reserva(Long id, String servicio, Date fechaInicio, Date fechaFin, Paquete paquete, Usuario usuario,
			Pago pago) {
		super();
		this.id = id;
		this.servicio = servicio;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.paquete = paquete;
		this.usuario = usuario;
		this.pago = pago;
	}

	public Reserva() {
		super();
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

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
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

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", servicio=" + servicio + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + "]";
	}

}