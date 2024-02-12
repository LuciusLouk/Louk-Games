package com.deluxe.backend.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Component
@PrimaryKeyJoinColumn(referencedColumnName="pro_id")
@Table(name="PAQUETES")
@Data @AllArgsConstructor @NoArgsConstructor
public class Paquete extends Producto{
	
	@Column(name="paq_descuento")
	private int decuento;
	
	@ManyToMany
	@JoinTable(name="paquetes_productos",
			joinColumns = @JoinColumn(name="paq_id"),
			inverseJoinColumns =@JoinColumn(name="pro_id")
			)
	private List<Producto> productos;
}
