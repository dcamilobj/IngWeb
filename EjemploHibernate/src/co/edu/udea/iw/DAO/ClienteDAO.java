/**
 * 
 */
package co.edu.udea.iw.DAO;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * Interface para definir los métodos del cliente en el sistema
 * @author dcamilo.bedoya
 *
 */
public interface ClienteDAO {

	
	/**
	 * Obtener todos los clientes de la base de datos ordenados por su fecha de creacion
	 * @return
	 * @throws MyException
	 */
	public List<Cliente> obtener()  throws MyException;
	public void guardar(Cliente cliente) throws MyException;
}
