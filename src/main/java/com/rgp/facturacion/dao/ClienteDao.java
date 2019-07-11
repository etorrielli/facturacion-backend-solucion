package com.rgp.facturacion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Cliente;

@Repository
public class ClienteDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int save(Cliente cliente) throws Exception {
		sessionFactory.getCurrentSession().save(cliente);
		return cliente.getId();
	}

	public Cliente get(int id) throws EntityNotFoundException, Exception {
		Cliente p = sessionFactory.getCurrentSession().get(Cliente.class, id);
		if (p == null) {
			throw new EntityNotFoundException("id: {" + String.valueOf(id) + "} no existe");
		}
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> list() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Cliente").list();
	}

	public void update(Cliente cliente) throws Exception {
		sessionFactory.getCurrentSession().save(cliente);
		sessionFactory.getCurrentSession().flush();
	}

	public void delete(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Cliente cliente = session.byId(Cliente.class).load(id);
		session.delete(cliente);
	}
}
