package com.rgp.facturacion.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rgp.facturacion.dao.ClienteDao;
import com.rgp.facturacion.dao.DetalleDao;
import com.rgp.facturacion.dao.FacturaDao;
import com.rgp.facturacion.dao.ProductoDao;
import com.rgp.facturacion.dto.DetalleDto;
import com.rgp.facturacion.dto.FacturaDto;
import com.rgp.facturacion.dto.Response;
import com.rgp.facturacion.exception.EntityNotFoundException;
import com.rgp.facturacion.model.Detalle;
import com.rgp.facturacion.model.Factura;

@Service
@Transactional
public class FacturaService {

	@Autowired
	private FacturaDao facturaDao;
	
	@Autowired
	private DetalleDao detalleDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private ProductoDao productoDao;

	public Response save(FacturaDto facturaDto) throws Exception {
		Response response = new Response();
		
		Factura factura = facturaDtoToEntity(facturaDto);
		int id = facturaDao.save(factura);
		
		for (DetalleDto item : facturaDto.getDetalles()) {
			Detalle detalle = detalleDtoToEntity(factura, item);
			int idDetalle = detalleDao.save(detalle);
		}
		
		response.setData(id);
		return response;
	}

	public Factura get(int id) throws EntityNotFoundException, Exception {
		return facturaDao.get(id);
	}

	public Response list() throws Exception {
		Response response = new Response();
		List<Factura> facturas = facturaDao.list();
		response.setData(facturas);
		return response;
	}

	private Factura facturaDtoToEntity(FacturaDto facturaDto) throws Exception {
		Factura factura = new Factura();
		factura.setFolio(facturaDto.getFolio());
		factura.setDescripcion(facturaDto.getDescripcion());
		factura.setObservacion(facturaDto.getObservacion());
		factura.setFecha(new Date());
		factura.setClienteId(clienteDao.get(facturaDto.getClienteId()));
		return factura;
	}
	
	private Detalle detalleDtoToEntity(Factura factura, DetalleDto detalleDto) throws Exception {
		Detalle detalle = new Detalle();
		detalle.setCantidad(detalleDto.getCantidad());
		detalle.setFacturaId(factura);
		detalle.setProductoId(productoDao.get(detalleDto.getProductoId()));
		return detalle;
	}
}














