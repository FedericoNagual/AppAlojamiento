package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author 
 * 
 * Modelo de la clase Ciudad con sus atributos
 *
 */
@Entity(name = "Ciudad")
@Table(name = "Ciudad")
public class Ciudad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ciudadId", unique = true, nullable = false)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "provinciaId")
	private Provincia provincia;

	
	public Ciudad(Long id, String nombre, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
	}

	public Ciudad() {
		super();
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

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	
	/**
	 * Imprime en formato String todos los datos
	 * de la clase
	 * 
	 * @return String datos de Ciudad
	 * 
	 */
	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + ", provincia=" + provincia  + "]";
	}

}