package com.rgp.facturacion.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Factura;

@Repository
public class FacturaDao {

	@Autowired
	private SessionFactory sessionFactory;

	public int save(Factura factura) throws Exception {
		sessionFactory.getCurrentSession().save(factura);
		return factura.getId();
	}

	public Factura get(int id) throws EntityNotFoundException, Exception {
		Factura p = sessionFactory.getCurrentSession().get(Factura.class, id);
		if (p == null) {
			throw new EntityNotFoundException("id: {" + String.valueOf(id) + "} no existe");
		}
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Factura> list() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Factura").list();
	}

	

	
}
