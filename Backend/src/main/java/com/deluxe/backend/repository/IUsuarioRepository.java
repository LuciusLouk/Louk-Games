package com.deluxe.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.deluxe.backend.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{

	/**
	 * Obtiene un usuario en base al nombre de usuario
	 * usado para en el registro de usuario
	 * @param usuario
	 * @return objeto de tipo usuario
	 */
	public Usuario findByEmail(String email);
}
