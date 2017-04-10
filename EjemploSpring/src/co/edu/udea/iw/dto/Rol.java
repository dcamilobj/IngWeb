/**
 * 
 */
package co.edu.udea.iw.dto;

/**
 * Esta clase implementa todos los atributos de la tabla "Roles" junto a sus getters an setters. 
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public class Rol {

	
	/**
	 * Atributos de la clase
	 */
	
	private String codigo; 
	private String nombre;
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
