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
 * Modelo de la clase OfertaAlojamiento con sus atributos
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