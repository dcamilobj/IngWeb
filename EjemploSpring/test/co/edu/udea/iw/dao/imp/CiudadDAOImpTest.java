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
 * Pruebas sobre los métodos correspondientes a la tabla ciudades en el sistema. 
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */

/*Anotacion para correr la prueba con otro runner*/
@RunWith(SpringJUnit4ClassRunner.class)	

/*Para decir que la clase es de tipo transacional */
@Transactional 				

/*Decirle a spring donde está el archivo de config. de spring para que cargue al inicio.*/
@ContextConfiguration(locations="classpath:SpringConfig.xml") 
public class CiudadDAOImpTest {
	
	@Autowired //Para decirle que lo inyecte -- Inicializa la variables(Spring lo hace)
	private CiudadDAO ciudadDAO;

	/**
	 * Prueba que devuelve la lista de ciudades que se encuentran en la base de datos.
	 */
	@Test
	public void testObtener() {
		List <Ciudad> ciudades = null;
		try{
			ciudades = ciudadDAO.obtener();
			assertTrue(ciudades.size()>0);   
			
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
	}

	/**
	 * Prueba para revisar si se está trayendo correctamente la ciudad que corresponde al código 1. 
	 */
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
			fail(e.getMessage());
		}
	}
	

}
