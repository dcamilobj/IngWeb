/**
 * 
 */
package co.edu.udea.iw.DAO;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author dcamilo.bedoya
 *
 */
public interface UsuarioDAO {

	/**
	 * 
	 * @param login
	 * @return
	 * @throws MyException
	 */
	public Usuario obtener(String login) throws MyException; 
}
