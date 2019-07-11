package com.rgp.facturacion.service;

import com.rgp.facturacion.dao.ClienteDao;
import com.rgp.facturacion.dto.Response;
import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    public Cliente get(int id) throws EntityNotFoundException, Exception {
        return clienteDao.get(id);
    }

    public Response list() throws Exception {
        Response response = new Response();
        List<Cliente> clientes = clienteDao.list();
        response.setData(clientes);
        return response;
    }


}














