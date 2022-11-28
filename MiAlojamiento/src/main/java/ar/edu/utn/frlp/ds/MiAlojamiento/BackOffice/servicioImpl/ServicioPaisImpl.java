package ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.DatosPais;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.modelo.Pais;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.repository.PaisRepository;
import ar.edu.utn.frlp.ds.MiAlojamiento.BackOffice.servicio.ServicioPais;


public class ServicioPaisImpl implements ServicioPais{
		
		@Autowired
		private PaisRepository paisRepository;

		/**
		 * Guarda la entity Pais
		 * 
		 */
		@Override
		public Pais guardarPais(Pais pais) {
			return paisRepository.saveAndFlush(pais);
		}

		/**
		 * Busca una entity Habitacion por nombre
		 * 
		 * @param nombre tipo String
		 * @return List<Habitacion> resultado de un Find a la BD filtrado por nombre
		 */
		@Override
		public List<Pais> buscarPaisXNombre(String nombre) {
			//Implementar metodo que devuelva todas las Habitaciones por el nombre pasado
			// por parametro
			// Traer la lista, filtrarla por nombre
			List<Pais> listaGeneral = paisRepository.findAll();
			List<Pais> lista = new ArrayList<Pais>();
			
			for (int i = 0; i < listaGeneral.size(); i++) {
				if (nombre.equals(listaGeneral.get(i).getNombre())) {
					lista.add(listaGeneral.get(i));
				}
				i++;
			}
			return lista;
		}

		/**
		 * Buscar entity Pais por Id
		 * 
		 * @param id tipo Long
		 * @return Pais resultado del metodo findById
		 */
		@Override
		public Pais buscarPaisXId(Long id) {
			return paisRepository.findById(id).get();
		}

		/**
		 * Obtener DatosPais
		 * 
		 * @return List<DatosPais> resultado del metodo findAllProjectedBy
		 */
		@Override
		public List<DatosPais> obtenerDatosPais() {
			return paisRepository.findAllProjectedBy();
		}

		/**
		 * Eliminar una entity Pais de la BD
		 */
		@Override
		public void eliminarPais(Long id) {
			paisRepository.deleteById(id);
		}

		
		

	}


