/**
 * 
 */
package co.edu.udea.iw.DAO;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta interfaz define las operaciones que se pueden hacer sobre la tabla usuario en el sistema.
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public interface UsuarioDAO {

	/**
	 * 
	 * @return la lista completa de los usuarios de la bd.
	 * @throws MyException
	 */
		public List<Usuario> obtener() throws MyException;
		
	
	/**
	 * @param Nombre de usuario 
	 * @return El usuario actual en el sistema dado su nombre de usuario. 
	 * @throws MyException
	 */
	public Usuario obtener(String login) throws MyException; 
}
