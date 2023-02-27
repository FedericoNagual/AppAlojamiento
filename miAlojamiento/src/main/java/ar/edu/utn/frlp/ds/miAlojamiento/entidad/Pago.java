package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Modelo de la clase Pago con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Pago")
@Table(name = "\"Pago\"")
public class Pago implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"pagoId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "monto")
	private Double monto;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "\"codigoBarra\"")
	private String codigoBarra;

	@Column(name = "\"ultimosDigitos\"")
	private Long ultimosDigitos;

	@Column(name = "cbu")
	private Long cbu;

	@OneToMany(mappedBy = "pago")
	private List<Reserva> listaReserva;

	public Pago(Long id, Double monto, Date fecha, String codigoBarra, Long ultimosDigitos, Long cbu,
			List<Reserva> listaReserva) {
		super();
		this.id = id;
		this.monto = monto;
		this.fecha = fecha;
		this.codigoBarra = codigoBarra;
		this.ultimosDigitos = ultimosDigitos;
		this.cbu = cbu;
		this.listaReserva = listaReserva;
	}

	public Pago() {
		super();
		setFecha(new Date());
	}

	public List<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Long getUltimosDigitos() {
		return ultimosDigitos;
	}

	public void setUltimosDigitos(Long ultimosDigitos) {
		this.ultimosDigitos = ultimosDigitos;
	}

	public Long getCbu() {
		return cbu;
	}

	public void setCbu(Long cbu) {
		this.cbu = cbu;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Pago
	 * 
	 */
	@Override
	public String toString() {
		return "Pago [id=" + id + ", monto=" + monto + ", fecha=" + fecha + ", codigoBarra=" + codigoBarra
				+ ", ultimosDigitos=" + ultimosDigitos + ", cbu=" + cbu + "]";
	}

}
