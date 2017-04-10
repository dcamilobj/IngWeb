package co.edu.udea.iw.dto;

/**
 * Esta clase implementa todos los atributos de la tabla "Ciudades" junto a sus getters an setters. 
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public class Ciudad {

	/**
	 * Atributos de la clase
	 */
	private Long codigo; 
	private String nombre; 
	private String codigoArea;
	/**
	 * @return the codigo
	 */
	public long getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(long codigo) {
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
	/**
	 * @return the codigoArea
	 */
	public String getCodigoArea() {
		return codigoArea;
	}
	/**
	 * @param codigoArea the codigoArea to set
	 */
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	
}
