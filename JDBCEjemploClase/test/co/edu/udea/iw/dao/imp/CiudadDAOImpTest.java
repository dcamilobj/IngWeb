package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * @author dcamilo.bedoya
 * Pruebas sobre la clase "CiudadDAOImp"
 */

public class CiudadDAOImpTest {

	@Test
	//Esta prueba va a fallar cuando la lista traida no contiene elementos(tamaño = 0) 
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		List <Ciudad> ciudades = null;
		try{
			ciudadDAO = new CiudadDAOImp();
			ciudades = ciudadDAO.obtener();
			assertTrue(ciudades.size()>0);   
			
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
		
	}
}
