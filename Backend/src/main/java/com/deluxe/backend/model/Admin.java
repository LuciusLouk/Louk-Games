package com.deluxe.backend.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Table(name="ADMINS")
@Data @AllArgsConstructor @NoArgsConstructor
public class Admin extends Usuario{
	@Column(name="ad_legajo",nullable=false)
	private String legajo;
}
