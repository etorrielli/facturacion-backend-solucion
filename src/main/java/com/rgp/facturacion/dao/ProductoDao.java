package com.rgp.facturacion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Producto;

@Repository
public class ProductoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int save(Producto producto) throws Exception {
		sessionFactory.getCurrentSession().save(producto);
		return producto.getId();
	}

	public Producto get(int id) throws EntityNotFoundException, Exception {
		Producto p = sessionFactory.getCurrentSession().get(Producto.class, id);
		if (p == null) {
			throw new EntityNotFoundException("id: {" + String.valueOf(id) + "} no existe");
		}
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Producto> list() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Producto").list();
	}

	public void update(Producto producto) throws Exception {
		sessionFactory.getCurrentSession().save(producto);
		sessionFactory.getCurrentSession().flush();
	}

	public void delete(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Producto producto = session.byId(Producto.class).load(id);
		session.delete(producto);
	}

}
