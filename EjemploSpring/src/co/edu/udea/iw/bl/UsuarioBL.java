/**
 * 
 */
package co.edu.udea.iw.bl;

import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.encode.Cipher;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase para implementar todos los métodos de la lógica de negocio correspondiente al usuario
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public class UsuarioBL {

	UsuarioDAO usuarioDAO;

	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	/**
	 * Método para validar el login y la contraseña que fueron ingresados.
	 * La contraseña ingresada se codificó por medio del método SHA-1,
	 * para luego compararse con la que se encuentra en la base de datos. 
	 * @param login
	 * @param password
	 * @throws MyException
	 */
	public Boolean validar(String login, String password) throws MyException
	{
		Cipher cipher = new Cipher();
		
		if(login.isEmpty() || login == null)
		{
			throw new MyException("El login no puede ser vacío");
		}
		if(password.isEmpty() || password == null)
		{
			throw new MyException("La password no puede ser vacía");
		}
		
		Usuario usuario = usuarioDAO.obtener(login);
		if(usuario == null)
		{
			throw new MyException("El usuario o la contraseña ingresada es incorrecta.");
		}
		
		if(!usuario.getContrasena().equals(cipher.encrypt(password)))
		{
			throw new MyException("El usuario o la contraseña ingresada es incorrecta.");
		}

		return Boolean.TRUE;
	}
}
