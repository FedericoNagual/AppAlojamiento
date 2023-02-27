package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Modelo de la clase Usuario con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Usuario")
@Table(name = "\"Usuario\"")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"usuarioId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "\"fechaNacimiento\"")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@Column(name = "\"tipoDocumento\"")
	private String tipoDocumento;

	@Column(name = "\"dni\"")
	private String dni;

	@Column(name = "telefono")
	private Long telefono;

	@OneToOne
	@JoinColumn(name = "\"domicilioId\"")
	private Domicilio domicilio;

	@OneToOne
	@JoinColumn(name = "\"loginId\"")
	private Login login;

	@OneToMany(mappedBy = "usuario")
	private List<Reserva> listaReserva; // 1 usuario puede tener muchas reservas

	@ManyToOne
	@JoinColumn(name = "\"rolId\"")
	private Rol rol;

	public Usuario() {
		super();
		setDomicilio(new Domicilio());
		setLogin(new Login());
		setRol(new Rol());
		setFechaNacimiento(new Date());
	}

	public Usuario(Long id, String nombre, String apellido, Date fechaNacimiento, String tipoDocumento, String dni,
			Long telefono, Domicilio domicilio, Login login, List<Reserva> listaReserva, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.tipoDocumento = tipoDocumento;
		this.dni = dni;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.login = login;
		this.listaReserva = listaReserva;
		this.rol = rol;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apelido) {
		this.apellido = apelido;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento="
				+ fechaNacimiento + ", dni=" + dni + "]";
	}
}