package co.edu.udea.iw.dao.imp;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.DAO.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:SpringConfig.xml")
public class UsuarioDAOImpTest {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Test
	public void testObtener() {
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
