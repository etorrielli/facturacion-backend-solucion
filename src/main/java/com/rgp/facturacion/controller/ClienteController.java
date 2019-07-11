package com.rgp.facturacion.controller;

import com.rgp.facturacion.dto.Response;
import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Cliente;
import com.rgp.facturacion.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> get(@PathVariable("id") int id) throws EntityNotFoundException, Exception {
        Cliente cliente = clienteService.get(id);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = clienteService.list();
        return ResponseEntity.ok().body(response);
    }

}
