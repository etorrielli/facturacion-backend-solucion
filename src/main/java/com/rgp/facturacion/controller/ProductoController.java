package com.rgp.facturacion.controller;

import com.rgp.facturacion.dto.Response;
import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Producto;
import com.rgp.facturacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/{id}")
    public ResponseEntity<Producto> get(@PathVariable("id") int id) throws EntityNotFoundException, Exception {
        Producto producto = productoService.get(id);
        return ResponseEntity.ok().body(producto);
    }

    @GetMapping()
    public ResponseEntity<?> list() throws Exception {
        Response response = productoService.list();
        return ResponseEntity.ok().body(response);
    }

}
