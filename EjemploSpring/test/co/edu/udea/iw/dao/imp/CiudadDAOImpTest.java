/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.DAO.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
import javassist.ClassPath;

/**
 * @author estudiantelis
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)//Anotaciones para correr la prueba con otro runner
@Transactional //Para decir que la clase es de tipo transacional 
@ContextConfiguration(locations="classpath:SpringConfig.xml") //Decirle a spring donde está el archivo de config. de spring para que cargue al inicio
public class CiudadDAOImpTest {
	
	@Autowired //Para decirle que lo inyecte -- Inicializa la variables(Spring lo hace)
	private CiudadDAO ciudadDAO;

	@Test
	public void testObtener() {
		List <Ciudad> ciudades = null;
		try{
			ciudades = ciudadDAO.obtener();
			assertTrue(ciudades.size()>0);   
			
		}
		catch(MyException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerLong() {
		Ciudad ciudad = null;
		try
		{
			ciudad = ciudadDAO.obtener(1l);
			assertEquals(ciudad.getNombre(),"Medellin");
		}
		catch(MyException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

}
