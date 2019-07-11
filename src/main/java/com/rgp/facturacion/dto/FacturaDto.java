package com.rgp.facturacion.dto;

import java.util.List;

public class FacturaDto {
	
	private Integer id;
	private Integer clienteId;
	private int folio;
    private String descripcion;
    private String observacion;
    private List<DetalleDto> detalles;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public List<DetalleDto> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleDto> detalles) {
		this.detalles = detalles;
	}
    
    

}
