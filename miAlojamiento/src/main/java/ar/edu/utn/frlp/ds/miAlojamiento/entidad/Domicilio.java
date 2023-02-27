package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase Domicilio con sus atributos
 * 
 * @author Mauro
 * @author Federico
 *
 */
@Entity(name = "Domicilio")
@Table(name = "\"Domicilio\"")
public class Domicilio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"domicilioId\"", unique = true, nullable = false)
	private Long id;

	@Column(name = "calle")
	private String calle;

	@Column(name = "altura")
	private String altura;

	@Column(name = "\"codigoPostal\"")
	private String codigoPostal;

	@ManyToOne
	@JoinColumn(name = "\"ciudadId\"")
	private Ciudad ciudad;

	public Domicilio(Long id, String calle, String altura, String codigoPostal, Ciudad ciudad) {
		super();
		this.id = id;
		this.calle = calle;
		this.altura = altura;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
	}

	public Domicilio() {
		super();
		setCiudad(new Ciudad());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * Imprime en formato String todos los datos de la clase
	 * 
	 * @return String datos de Domicilio
	 * 
	 */
	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", calle=" + calle + ", altura=" + altura + ", codigoPostal=" + codigoPostal
				+ "]";
	}

}
