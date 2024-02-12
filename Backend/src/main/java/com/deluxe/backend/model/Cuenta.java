package com.deluxe.backend.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name="CUENTAS")
@Data @AllArgsConstructor @NoArgsConstructor
public class Cuenta {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="cue_id", nullable =false)
	private Long id;
	@Column(name="cue_nickname", nullable =false)
	private String nickname;
	@Column(name="cue_saldo", nullable =false)
	private double saldo;
	@Column(name="cue_foto")
	private String fotoPerfil;
	
	//*****************************************//
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="biblioteca",
			joinColumns = @JoinColumn(name="cue_id"),
			inverseJoinColumns =@JoinColumn(name="prod_id")
			)
	private List<Producto> biblioteca=new ArrayList<Producto>();
	
	//**************************************//
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="carritos",
			joinColumns = @JoinColumn(name="cue_id"),
			inverseJoinColumns =@JoinColumn(name="prod_id")
			)
	private List<Producto> carrito;
	
	//******************************************//
	@OneToMany(mappedBy = "cuenta")
	private List<Factura> facturas;
}
