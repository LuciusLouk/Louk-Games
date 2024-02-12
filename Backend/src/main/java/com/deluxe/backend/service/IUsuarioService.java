package com.deluxe.backend.service;
import com.deluxe.backend.model.Usuario;

public interface IUsuarioService extends IGenericCRUDService<Usuario>{
	public Usuario getUsuarioValidation(String email);
}
