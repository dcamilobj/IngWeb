package co.edu.udea.iw.DAO;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz define las operaciones que se pueden hacer sobre la tabla ciudades en el sistema. 
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public interface CiudadDAO {

	/**
	 * 
	 * @return la lista completa de las ciudades de la bd.
	 * @throws MyException
	 */
		public List<Ciudad> obtener() throws MyException;
		
	/**
	 * 
	 * @param código de la ciudad que se desea obtener
	 * @return una ciudad en base al código pasado por parametro 
	 * @throws MyException
	 */
		public Ciudad obtener(Long codigo) throws MyException; 
		
		
		/**
		 * 
		 * Definición de método para guardar una ciudad en la base de datos.
		 * @param ciudad que se desea guardar
		 * @throws MyException
		 */
		public void guardar(Ciudad ciudad) throws MyException;
}
