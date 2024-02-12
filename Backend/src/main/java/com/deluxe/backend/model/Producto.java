package com.deluxe.backend.model;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Inheritance( strategy = InheritanceType.JOINED)
@Table(name="PRODUCTOS")
@Data @AllArgsConstructor @NoArgsConstructor
public abstract class Producto {
	
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="pro_id")
	private Long id;
	@Column(name="pro_nombre", nullable =false)
	private String nombre;
	@Column(name="pro_precio", nullable =false)
	private Double precio;
	@Column(name="pro_descripcion", nullable =false)
	private String descripcion;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="edi_id",nullable=false)
	private Editor editor;
	
	@ManyToMany(mappedBy = "productos")
	private List<Paquete> paquetes;
	
}
