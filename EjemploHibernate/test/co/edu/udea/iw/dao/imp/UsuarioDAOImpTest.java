/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.iw.DAO.CiudadDAO;
import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author dcamilo.bedoya
 *
 */
public class UsuarioDAOImpTest{

	/**
	 * Test method for {@link co.edu.udea.iw.dao.imp.UsuarioDAOImp#obtener(java.lang.String)}.
	 */
	@Test
	public void testObtener() {
		UsuarioDAO usuarioDAO = null;
		Usuario usuario = null;
		try
		{
			usuarioDAO = new UsuarioDAOImp();
			usuario = usuarioDAO.obtener("elver");
			assertEquals(usuario.getNombres(), "Elver");
			System.out.println("Nombre " + usuario.getNombres() + "Rol:" +usuario.getRol());
		}
		catch(MyException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
