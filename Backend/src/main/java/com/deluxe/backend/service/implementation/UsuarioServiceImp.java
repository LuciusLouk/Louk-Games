package com.deluxe.backend.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deluxe.backend.model.Usuario;
import com.deluxe.backend.repository.IUsuarioRepository;
import com.deluxe.backend.service.IUsuarioService;
@Service
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	IUsuarioRepository usuarioRepository;


	@Override
	public Usuario getUsuarioValidation(String email) {
		// TODO Auto-generated method stub
		return usuarioRepository.findByEmail(email);
	}
	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override 
	public Usuario getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getEmpty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario setObject(Usuario o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modObject(Usuario o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delObject(Long id) {
		// TODO Auto-generated method stub

	}

}
