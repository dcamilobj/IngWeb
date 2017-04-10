/**
 * 
 */
package co.edu.udea.iw.DAO;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz define las operaciones que se pueden hacer sobre la tabla clientes en el sistema.	
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public interface ClienteDAO {

	
	/** 
	 * @return todos los clientes de la base de datos ordenados por su fecha de creacion
	 * @throws MyException
	 */
	public List<Cliente> obtener()  throws MyException;
	
	/**
	 * 
	 * @param cédula del cliente que se desea obtener
	 * @return El cliente en base a la cédula pasada por parametro 
	 * @throws MyException
	 */
		public Cliente obtener(String cedula) throws MyException; 
	
	
	/**
	 * Este método guarda un cliente en la base de datos.
	 * @param cliente que se desea guardar
	 * @throws MyException
	 */
	public void guardar(Cliente cliente) throws MyException;
}
