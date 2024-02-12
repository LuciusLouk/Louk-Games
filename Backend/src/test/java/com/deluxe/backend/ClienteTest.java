package com.deluxe.backend;


import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deluxe.backend.model.Cliente;
import com.deluxe.backend.model.Cuenta;
import com.deluxe.backend.repository.IClienteRepository;
import com.deluxe.backend.service.IClienteService;
import com.deluxe.backend.service.implementation.ClienteServiceImp;
@SpringBootTest
class ClienteTest {

	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IClienteRepository clienteRepository;
	
	
	
	
	@Test
	void AltaTest() {
		Cuenta  c = new Cuenta(null, "Blondie", 0,"asd", null, null, null);
		
		Cliente cliente = new Cliente("Eastwood", 
				"Clint", LocalDate.of(1932, 11, 24),
				388, 4664825, c, null);

				cliente.setEmail("import.cuenta.spring@gmail.com");
				cliente.setPassword("23141");
				cliente.setFechaCreacion(LocalDate.now());
				cliente.setEstado(true);
				cliente.setPerfil("CLIENTE");
				//clienteRepository.save(cliente);
				clienteService.setObject(cliente);				
				
	}
}
