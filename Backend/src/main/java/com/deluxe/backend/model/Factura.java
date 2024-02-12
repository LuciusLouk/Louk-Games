package com.deluxe.backend.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name="FACTURAS")
@Data @AllArgsConstructor @NoArgsConstructor
public class Factura {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="fac_id",nullable = false)
	private Long id;
	@Column(name="fac_total",nullable = false)
	private double precioTotal;
	@Column(name="fac_fecha",nullable = false)
	private LocalDate fechaCompra;
	
	@ManyToOne
	@JoinColumn(name="cue_id",nullable=false)
	private Cuenta cuenta;

	@OneToMany(mappedBy="factura")
	private List<DetalleFactura> detalles;
}
