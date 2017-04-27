/**
 * 
 */
package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.ClienteBL;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.ClienteJersey;
import co.edu.udea.iw.exception.MyException;

/**
 * @author dcamilo.bedoya
 * @version 1.0
 */
@Path("cliente")
@Component  //Para que se relacione con el archivo de configuración Spring
public class ClienteWS {

	@Autowired
	private ClienteBL clienteBL;
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	/**
	 * 
	 * @param cedula
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param usuarioCrea
	 * @throws RemoteException Para mostrar un mensaje cuando hay un error
	 */
	public void guardar(@QueryParam("cedula")String cedula, 
			@QueryParam("nombres")String nombres,
			@QueryParam("apellidos")String apellidos,
			@QueryParam("email")String email, 
			@QueryParam("usuarioCrea")String usuarioCrea) throws RemoteException 
	{
		try
		{
		  clienteBL.guardar(cedula, nombres, apellidos, email, usuarioCrea);
		}catch(MyException e)
		{
			throw new RemoteException("Error creando el usuario", e);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteJersey> obtener() throws RemoteException
	{
		List<ClienteJersey> respuesta = new ArrayList<ClienteJersey>();
		try{
			for(Cliente cliente: clienteBL.obtener())
			{
				ClienteJersey clienteJersey = new ClienteJersey(
						cliente.getNombres(),
						cliente.getNombres(), 
						cliente.getApellidos(), 
						cliente.getEmail());
				respuesta.add(clienteJersey);
			}
		}catch(MyException e)
		{
			throw new RemoteException("Error obteniendo clientes",e);
		}
		return respuesta;
	}
} 
