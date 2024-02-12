package com.deluxe.backend.model;

import java.time.LocalDate;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Inheritance( strategy = InheritanceType.JOINED)
@Table(name="USUARIOS")
@Data @AllArgsConstructor @NoArgsConstructor
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="usu_email")
	private String email;
	@Column(name="usu_password")
	private String password;
	@Column(name="usu_fecha_creacion")
	private LocalDate fechaCreacion;
	@Column(name="usu_estado")
	private boolean estado;
	@Column(name="usu_perfil")
	private String perfil;
	@Column(name="usu_pais")
	private String pais;
	
}
