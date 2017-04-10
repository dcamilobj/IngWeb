package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * 
 * Pruebas sobre los métodos correspondientes a la tabla usuarios en el sistema. 
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfig.xml")
public class UsuarioDAOImpTest {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Prueba que devuelve la lista de usuarios que se encuentran en la base de datos.
	 */
	@Test
	public void testObtener() {
		List <Usuario> usuarios= null;
		try{
			usuarios = usuarioDAO.obtener();
			assertTrue(usuarios.size()>0);   
			
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
	}
	
	/**
	 * Prueba para revisar que se obtiene correctamente un usuario dado su nombre de usuario.
	 */
	@Test
	public void testObtenerString() {
		Usuario usuario = null;
		try
		{
			usuario = usuarioDAO.obtener("elver");
			assertEquals(usuario.getNombres(), "Elver");
			System.out.println("Nombre " + usuario.getNombres() + " Rol:" +usuario.getRol().getNombre());
		}
		catch(MyException e)
		{
			fail(e.getMessage());
		}
	}

}
