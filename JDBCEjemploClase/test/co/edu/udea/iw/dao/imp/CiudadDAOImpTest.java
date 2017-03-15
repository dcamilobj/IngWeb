package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDAOImpTest {

	@Test
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
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testObtenerLong() {
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try
		{
			ciudadDAO = new CiudadDAOImp();
			ciudad = ciudadDAO.obtener(1l);
			assertEquals(ciudad.getNombre(),"Medellin");
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
	}

}
