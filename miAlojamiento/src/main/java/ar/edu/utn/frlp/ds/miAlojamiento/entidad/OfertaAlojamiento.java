package ar.edu.utn.frlp.ds.miAlojamiento.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Modelo de la clase OfertaAlojamiento con sus atributos
 * 
 * @author Mauro
 *
 */
@Entity(name = "OfertaAlojamiento")
@Table(name = "OfertaAlojamiento")
public class OfertaAlojamiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ofertaAlojamientoId", unique = true, nullable = false)
	private Long id;

	@Column(name = "alojamientoId")
	private Alojamiento alojamiento;

	@Column(name = "ofertaId")
	private Oferta oferta;

	public OfertaAlojamiento(Long id, Alojamiento alojamiento, Oferta oferta) {
		super();
		this.id = id;
		this.alojamiento = alojamiento;
		this.oferta = oferta;
	}

	public OfertaAlojamiento() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	@Override
	public String toString() {
		return "OfertaAlojamiento [id=" + id + ", alojamiento=" + alojamiento + ", oferta=" + oferta + "]";
	}

}