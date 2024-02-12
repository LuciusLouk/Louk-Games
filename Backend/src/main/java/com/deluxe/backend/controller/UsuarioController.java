package com.deluxe.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deluxe.backend.model.Cliente;
import com.deluxe.backend.model.Editor;
import com.deluxe.backend.model.Usuario;
import com.deluxe.backend.repository.IEditorRepository;
import com.deluxe.backend.repository.IUsuarioRepository;
import com.deluxe.backend.service.implementation.ClienteServiceImp;
import com.deluxe.backend.service.implementation.EditorServiceImp;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = {"http://localhost:4200/"})
public class UsuarioController {
	
	
	@Autowired
	ClienteServiceImp clienteService;
	
	@Autowired
	EditorServiceImp editorService;
	
	
	@Autowired
	IEditorRepository editorRepository;
	
	@Autowired
	IUsuarioRepository usuarioService;

	
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) usuarioService.findAll();
	}
	
	/**
	 * Usado para validar usuarios repetidos en registro de usuarios
	 * @param email
	 * @return
	 */
	@GetMapping("/usuarios/{email}")
	public Usuario getUsuario(@PathVariable(value="email")String email) {
		//System.out.println(usuarioService.findByEmail(email).getEmail());
		return usuarioService.findByEmail(email);
	}
	
	
	//*********** EDITORES ***********//
	
	@GetMapping("/editores")
	public List<Editor> getEditores(){
		System.out.println(editorRepository.findAll());
		return editorService.getAll();
	}
	@PostMapping("/editores")
	public Editor createEditor(@RequestBody Editor editor) {
		System.out.println("entró: "+editor);
		return editorService.setObject(editor);
	}
	
	//********** CLIENTES  ************//
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clienteService.getAll();
	}
	
	@PostMapping("/clientes")
	public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteService.setObject(cliente);
	}
	

}
