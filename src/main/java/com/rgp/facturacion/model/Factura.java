/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rgp.facturacion.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author edgar
 */
@Entity
@Table(name = "factura")
@NamedQueries({ @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
		@NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id"),
		@NamedQuery(name = "Factura.findByFolio", query = "SELECT f FROM Factura f WHERE f.folio = :folio"),
		@NamedQuery(name = "Factura.findByDescripcion", query = "SELECT f FROM Factura f WHERE f.descripcion = :descripcion"),
		@NamedQuery(name = "Factura.findByObservacion", query = "SELECT f FROM Factura f WHERE f.observacion = :observacion"),
		@NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha") })
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "folio")
	private int folio;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "observacion")
	private String observacion;
	@JsonIgnore
	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Transient
	private String fechaFormat;
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Cliente clienteId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaId", fetch = FetchType.EAGER)
	private List<Detalle> detalleList;

	public Factura() {
	}

	public Factura(Integer id) {
		this.id = id;
	}

	public Factura(Integer id, int folio) {
		this.id = id;
		this.folio = folio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.fechaFormat = sdf.format(this.getFecha());
		return fechaFormat;
	}

	public void setFechaFormat(String fechaFormat) {
		this.fechaFormat = fechaFormat;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public List<Detalle> getDetalleList() {
		return detalleList;
	}

	public void setDetalleList(List<Detalle> detalleList) {
		this.detalleList = detalleList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Factura)) {
			return false;
		}
		Factura other = (Factura) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.rgp.facturacion.model.Factura[ id=" + id + " ]";
	}

}
