package com.rgp.facturacion.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Detalle;

@Repository
public class DetalleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductoDao productoDao;

    public int save(Detalle detalle) throws Exception {
		sessionFactory.getCurrentSession().save(detalle);
		return detalle.getId();
	}

	public Detalle get(int id) throws EntityNotFoundException, Exception {
		Detalle p = sessionFactory.getCurrentSession().get(Detalle.class, id);
		if (p == null) {
			throw new EntityNotFoundException("id: {" + String.valueOf(id) + "} no existe");
		}
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Detalle> list() throws Exception {
		return sessionFactory.getCurrentSession().createQuery("from Detalle").list();
	}

	public void update(Detalle detalle) throws Exception {
		sessionFactory.getCurrentSession().save(detalle);
		sessionFactory.getCurrentSession().flush();
	}

	public void delete(int id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Detalle detalle = session.byId(Detalle.class).load(id);
		session.delete(detalle);
	}

    
}
