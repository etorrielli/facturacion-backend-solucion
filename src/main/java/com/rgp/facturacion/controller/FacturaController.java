package com.rgp.facturacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgp.facturacion.dto.FacturaDto;
import com.rgp.facturacion.dto.Response;
import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Factura;
import com.rgp.facturacion.service.FacturaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/facturas")
public class FacturaController {

	@Autowired
	private FacturaService facturaService;

	@PostMapping
    public ResponseEntity<?> save(@RequestBody FacturaDto facturaDTO) throws Exception {
        Response response = facturaService.save(facturaDTO);
        return ResponseEntity.ok().body(response);
    }

	@GetMapping("/{id}")
	public ResponseEntity<Factura> get(@PathVariable("id") int id) throws EntityNotFoundException, Exception {
		Factura factura = facturaService.get(id);
		return ResponseEntity.ok().body(factura);
	}

	@GetMapping()
	public ResponseEntity<?> list() throws Exception {
		Response response = facturaService.list();
		return ResponseEntity.ok().body(response);
	}

}
