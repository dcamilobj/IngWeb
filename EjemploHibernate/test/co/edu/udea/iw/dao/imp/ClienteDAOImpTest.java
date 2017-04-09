/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.DAO.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author dcamilo.bedoy
 *
 */
public class ClienteDAOImpTest {

	/**
	 * Test method for {@link co.edu.udea.iw.dao.imp.ClienteDAOImp#obtener()}.
	 */
	@Test
	public void testObtener() {
		ClienteDAO clienteDAO = null;
		List<Cliente> resultado = null;
		
		try{
			clienteDAO = new ClienteDAOImp();
			resultado = clienteDAO.obtener();
			
			assertTrue(resultado.size()>0);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar() {
		
		Cliente cliente = null;
		ClienteDAO clienteDAO = null;
		Usuario usuario= null;
		
		try{
			cliente = new Cliente();
			cliente.setCedula("16");
			cliente.setNombres("Camilo");
			cliente.setApellidos("Apellidos");
			cliente.setEmail("dcamilo.bedoya@udea.edu.co");
			
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			clienteDAO = new ClienteDAOImp();
			clienteDAO.guardar(cliente);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

}
