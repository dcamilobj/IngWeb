/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.DAO.CiudadDAO;
import co.edu.udea.iw.DAO.ClienteDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Pruebas sobre los métodos correspondientes a la tabla clientes en el sistema. 
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional 
@ContextConfiguration(locations="classpath:SpringConfig.xml") 
public class ClienteDAOImpTest {

	
	@Autowired //Para decirle que lo inyecte -- Inicializa la variables(Spring lo hace)
	private ClienteDAO clienteDAO;
	
	/**
	 * Prueba que devuelve la lista de clientes que se encuentran en la base de datos.
	 */
	@Test
	public void testObtener() {
		List<Cliente> resultado = null;
		
		try{
			resultado = clienteDAO.obtener();
			
			assertTrue(resultado.size()>0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba para revisar el correcto ingreso de un cliente en la base de datos.
	 */
	@Test
	public void testGuardar() {
		
		Cliente cliente = null;
		Usuario usuario= null;
		
		try{
			cliente = new Cliente();
			cliente.setCedula("15"); //Cambiar después de cada ejecución
			cliente.setNombres("Camilo");
			cliente.setApellidos("Apellidos");
			cliente.setEmail("dcamilo.bedoya@udea.edu.co");
			
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			clienteDAO.guardar(cliente);
			
		}catch(MyException e){
			fail(e.getMessage());
		}
	}
}
