package com.rgp.facturacion.service;

import com.rgp.facturacion.dao.ProductoDao;
import com.rgp.facturacion.dto.Response;
import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoDao productoDao;

    public Producto get(int id) throws EntityNotFoundException, Exception {
        return productoDao.get(id);
    }

    public Response list() throws Exception {
        Response response = new Response();
        List<Producto> productos = productoDao.list();
        response.setData(productos);
        return response;
    }


}














