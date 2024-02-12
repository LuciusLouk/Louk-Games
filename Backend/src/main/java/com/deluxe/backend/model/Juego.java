package com.deluxe.backend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Component
@PrimaryKeyJoinColumn(referencedColumnName="pro_id")
@Table(name="JUEGOS")
@Data @AllArgsConstructor @NoArgsConstructor
public class Juego extends Producto{
	
	@Column(name="jue_genero")
	private String genero;

	@Column(name="jue_idioma")
	private String idioma;
	
	@Column(name="jue_fecha_publicacion", nullable =false)
	private LocalDate fechaPublicacion;
	
	@ManyToMany(mappedBy = "biblioteca")
	private List<Cuenta> bibliotecas = new ArrayList<Cuenta>();

	@ManyToMany(mappedBy = "carrito")
	private List<Cuenta> carritos = new ArrayList<Cuenta>();
}
