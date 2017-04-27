/**
 * 
 */
package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.DAO.ClienteDAO;
import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Clase para implementar todos los métodos de la lógica de negocio correspondiente al cliente 
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
@Transactional
public class ClienteBL {

	private ClienteDAO clienteDAO;
	private UsuarioDAO usuarioDAO; //Validar que el usuario que crea exista

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
	 * @return the clienteDAO
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	/**
	 * @param clienteDAO the clienteDAO to set
	 */
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	/**
	 * 
	 * @return lista de clientes
	 * @throws MyException
	 */
	public List<Cliente> obtener() throws MyException
	{
		return clienteDAO.obtener();
	}
	/**
	 * 
	 * @param cedula
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param usuarioCrea
	 */
	public void guardar(String cedula, String nombres, String apellidos, String email, String usuarioCrea) throws MyException
	{
		if(cedula.isEmpty() || cedula ==null)
		{
			throw new MyException("La cédula no puede estar vacía");
		}
		
		if(nombres.isEmpty() || nombres ==null)
		{
			throw new MyException("El campo 'Nombres' no puede estar vacío");
		}
		
		if(apellidos.isEmpty() || apellidos ==null)
		{
			throw new MyException("El campo 'Apellidos' no puede estar vacío");
		}
		
		if(email.isEmpty() || email==null)
		{
			throw new MyException("El email no puede estar vacío");
		}
		
		if(usuarioCrea.isEmpty() || usuarioCrea==null)
		{
			throw new MyException("El usuario que crea el cliente no puede estar vacío");
		}
		
		Usuario usuario = usuarioDAO.obtener(usuarioCrea);
		if(usuario == null)
		{
			throw new MyException("El usuario que crea el cliente no existe en el sistema");
		}
		
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setUsuarioCrea(usuario);
		cliente.setFechaCreacion(new Date());
		cliente.setEliminado(Boolean.FALSE);
		
	}
	
	/*VALIDAR FORMATO EMAIL*/
	/*VALIDAR TAMAÑO CAMPOS*/
	/*CLASE LÓGICA DEL NEGOCIO DE USUARIO CON UN MÉTODO QUE ME PERMITA VALIDAR EL USUARIO DADO
	 *SU PASSWORD*/
	
}
