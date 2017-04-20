/**
 * 
 */
package co.edu.udea.iw.ws;



import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author dcamilo.bedoya
 *¡Para que esta clase se convierta en un ws debo agregar algunas anotaciones!
 */
@Path("saludo") //Ruta de la URL
public class PrimerEjemplo {

	@GET//Método con el que quiero que responda esta función
	@Produces(MediaType.TEXT_HTML) //Lo que va a entregar la función 
	public String saludar()
	{
		return "Buenas tardes";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("2")
	public String saludar2()
	{
		return "Hello baby";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("3")
	//Pedir parametros utilizando la URL @QueryParam
	public String  saludar3(@QueryParam("a")String nombre)
	{
		return "Buenas tardes " + nombre;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("4/{a}")
	//Pedir parametros utilizando la URL @PathParam
	public String  saludar4(@PathParam("a") String nombre)
	{
		return "Buenas loca: " + nombre;
	}
	
}
