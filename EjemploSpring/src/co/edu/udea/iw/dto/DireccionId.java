/**
 * 
 */
package co.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Esta clase implementa los atributos que hacen parte de la clave primaria compuesta 
 * de la tabla dirección, es "Serializable" para que se pueda cargar en el cache de hibernate.
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public class DireccionId implements Serializable{

		/**
		 * Atributos de la clase
		 */
		private Long codigo;
		private Cliente cliente;
		
		/**
		 * @return the codigo
		 */
		public Long getCodigo() {
			return codigo;
		}
		/**
		 * @param codigo the codigo to set
		 */
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		/**
		 * @return the cliente
		 */
		public Cliente getCliente() {
			return cliente;
		}
		/**
		 * @param cliente the cliente to set
		 */
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		

		
		
}
