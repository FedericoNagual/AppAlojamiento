package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosFoto;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Foto;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.FotoRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioFoto;



	public class ServicioFotoImpl implements ServicioFoto{
		@Autowired
		private FotoRepository fotoRepository;

		/**
		 * Guarda la entity Foto
		 * 
		 */
		@Override
		public Foto guardarFoto(Foto foto) {
			return fotoRepository.saveAndFlush(foto);
		}

		/**
		 * Busca una entity Foto por nombre
		 * 
		 * @param nombre tipo String
		 * @return List<Ciudad> resultado de un Find a la BD filtrado por nombre
		 */
		@Override
		public List<Foto> buscarFotoXUrl(String nombre) {
			//Implementar metodo que devuelva todas las Ciudad por el nombre pasado
			// por parametro
			// Traer la lista, filtrarla por nombre
			List<Foto> listaGeneral = fotoRepository.findAll();
			List<Foto> lista = new ArrayList<Foto>();
			
			for (int i = 0; i < listaGeneral.size(); i++) {
				if (nombre.equals(listaGeneral.get(i).getUrl())) {
					lista.add(listaGeneral.get(i));
				}
				i++;
			}
			return lista;
		}

		/**
		 * Buscar entity Provincia por Id
		 * 
		 * @param id tipo Long
		 * @return Provincia resultado del metodo findById
		 */
		@Override
		public Foto buscarFotoXId(Long id) {
			return fotoRepository.findById(id).get();
		}

		/**
		 * Obtener DatosFoto
		 * 
		 * @return List<DatosFoto> resultado del metodo findAllProjectedBy
		 */
		@Override
		public List<DatosFoto> obtenerDatosFoto() {
			return fotoRepository.findAllProjectedBy();
		}

		/**
		 * Eliminar una entity Foto de la BD
		 */
		@Override
		public void eliminarFoto(Long id) {
			fotoRepository.deleteById(id);
		}

		
		

	}





