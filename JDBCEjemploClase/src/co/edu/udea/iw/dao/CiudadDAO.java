/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author dcamilo.bedoya
 * @version 1.0
 */
public interface CiudadDAO {

	//Entrega la lista completa de las ciudades en la BD ordenadas por su nombre
		public List<Ciudad> obtener() throws MyException;
}
