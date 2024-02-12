package com.deluxe.backend.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name="DetallesFactura")
@Data @AllArgsConstructor @NoArgsConstructor
public class DetalleFactura {
	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="det_id")
	private Long id;
	
	@Column(name="det_precio")
	private double precioProducto;
	@Column(name="det_nombre")
	private String nombreProducto;
	@Column(name="prod_id")
	private String idProducto;
	
	@ManyToOne
	@JoinColumn(name="fac_id",nullable=false)
	private Factura factura;
}
