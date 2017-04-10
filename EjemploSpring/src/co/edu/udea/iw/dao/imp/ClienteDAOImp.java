/**
 * 
 */
package co.edu.udea.iw.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.DAO.ClienteDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyException;

/**
 * Esta clase implementa los métodos definidos en la interfaz "ClienteDAO"
 * @author Duban Camilo Bedoya Jiménez
 * @version 1.0
 */
public class ClienteDAOImp implements ClienteDAO {
	
	private SessionFactory sessionFactory;
	
	

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 * @return todos los clientes de la base de datos ordenados por su fecha de creacion
	 * @throws MyException
	 */
	@Override
	public List<Cliente> obtener() throws MyException {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Session session= null;
		Criteria criteria =null;
		
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(Cliente.class);
			criteria.addOrder(Order.asc("fechaCreacion"));     //ordenar criteria
			//Retornar la lista de clientes (select * from clientes order by Fecha Creacion asc;)
			clientes = criteria.list();
		}catch(HibernateException e)
		{
			throw new MyException("Error consultando la lista de clientes", e);
		}
		return clientes;
	}
	
	/**
	 * @param Cédula del cliente que se desea obtener
	 * @return El cliente en base a la cédula pasada por parametro 
	 * @throws MyException
	 */	
	@Override
	public Cliente obtener(String cedula) throws MyException {
		
		Cliente cliente= new Cliente();
		Session session = null;
		try{
			session = sessionFactory.getCurrentSession();
			cliente = (Cliente) session.get(Cliente.class,cedula);
		}
		catch(HibernateException e)
		{
			throw new MyException("Error consultando clientes", e);
		}
		return cliente;
	}

	/**
	 * 
	 * Esta es la implementación del método para guardar un cliente en la base de datos.
	 * @param cliente que se desea guardar
	 * @throws MyException
	 */
	@Override
	public void guardar(Cliente cliente) throws MyException {
		// TODO Auto-generated method stub
		Session session = null;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(cliente);
		}catch(HibernateException e)
		{
			throw new MyException("Ocurrió un error guardando el cliente",e);
		}
		
	}

}
