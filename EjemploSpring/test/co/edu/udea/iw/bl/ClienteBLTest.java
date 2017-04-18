/**
 * 
 */
package co.edu.udea.iw.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.DAO.ClienteDAO;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * xxxxxxxxxxxxxxxx
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional 
@ContextConfiguration(locations="classpath:SpringConfig.xml") 
public class ClienteBLTest {

	
	@Autowired //Para decirle que lo inyecte -- Inicializa la variables(Spring lo hace)
	private ClienteDAO clienteDAO;
	
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
}
