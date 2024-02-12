package com.deluxe.backend.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.PrimaryKeyJoinColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Table(name="CLIENTES")
@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente extends Usuario{
/*
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="cli_id", nullable =false)
	private Long id;
	
	*/
	@Column(name="cli_apellido")
	private String apellido;
	@Column(name="cli_nombres")
	private String nombre;
	@Column(name="cli_nacimiento")
	private LocalDate fechaNacimiento;
	@Column(name="cli_area_tel")
	private int codArea;
	@Column(name="cli_tel")
	private long telefono;
	
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cue_id")
	private Cuenta cuenta;
	
	 @ManyToMany
	 @JoinTable(
	     name = "amigos",
	     joinColumns = @JoinColumn(name = "cliente_id"),
	     inverseJoinColumns = @JoinColumn(name = "amigo_id")
	 )
	 private List<Cliente> amigos;

	 
	 
	 
}
