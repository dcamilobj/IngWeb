/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

/**
 * @author dcamilo.bedoya
 *
 */
public class CiudadDAOImp {
	/**
	 * 
	 */
	public List<Ciudad> obtener() throws MyException{
		
		PreparedStatement ps =null; //Realizamos la consulta
		Connection con=null;
		ResultSet rs =null; //Contiene los datos obtenidos de la consulta realizada
		List<Ciudad> ciudades =new ArrayList<>();
		try
		{
			con=DataSource.getConnection();
			ps=con.prepareStatement("select * from ciudades");
			rs = ps.executeQuery();
			while(rs.next())  //iterar datos traidos, retorna false cuando se dejan de traer datos
			{
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				ciudades.add(ciudad);
			}
		}
		catch(SQLException  e)
		{
			throw new MyException("Error consultando", e);
		}
		finally{
			try
			{
				if(rs!=null)
					rs.close();
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e)
			{
				throw new MyException("Error cerrando", e);
			}
		}
		return ciudades;
		
	}
}
