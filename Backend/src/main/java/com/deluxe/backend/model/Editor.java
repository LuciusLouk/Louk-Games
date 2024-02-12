package com.deluxe.backend.model;


import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Table(name="EDITORES")
@Data @AllArgsConstructor @NoArgsConstructor
public class Editor extends Usuario{
	
	@Column(name="edi_nombre_empresa")
	private String nombreEmpresa;
	@Column(name="edi_tipo_empresa")
	private String tipoEmpresa;
	@Column(name="edi_direccion")
	private String direccion;
	@Column(name="edi_localidad")
	private String localidad;
	@Column(name="edi_estado_provincia")
	private String estadoProvincia;
	@Column(name="edi_cod_postal")
	private int codPostal;
	@OneToMany(mappedBy = "editor")
	private List<Producto> productos;
	
}
