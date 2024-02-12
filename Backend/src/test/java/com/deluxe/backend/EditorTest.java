package com.deluxe.backend;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deluxe.backend.model.Editor;
import com.deluxe.backend.service.implementation.EditorServiceImp;
@SpringBootTest
class EditorTest {

	@Test
	void test() {
		//fail("Not yet implemented");
	}
	
	@Autowired
	EditorServiceImp editorService;
	
	@Test
	void altaTest() {
		Editor e = new Editor();
		e.setCodPostal(4600);
		e.setDireccion("La Mendieta");
		e.setEmail("deluk231lukkah@gmail.com");
		e.setEstado(true);
		e.setEstadoProvincia("Jujuy");
		e.setFechaCreacion(LocalDate.now());
		e.setLocalidad("Dr Manuel Belgrano");
		e.setNombreEmpresa("Louk");
		e.setPais("Argentina");
		e.setPassword("asdasd");
		e.setPerfil("EDITOR");
		e.setProductos(null);
		e.setTipoEmpresa("indie");
	
		editorService.setObject(e);
	
	
	
	
	}
	/*
	 * 
	 * 
	 * @Test
	void AltaTest() {
		Cuenta c = new Cuenta(null, "Blondie", 0, null, null, null);
		
		Cliente cliente = new Cliente("Eastwood", 
				"Clint", LocalDate.of(1932, 11, 24),
				388, 4664825, c, null);

				cliente.setEmail("import.cuenta.spring@gmail.com");
				cliente.setPassword("23141");
				cliente.setFechaCreacion(LocalDate.now());
				cliente.setEstado("CLIENTE");
					
				//clienteRepository.save(cliente);
				clienteService.setObject(cliente,c);				
				
	}
	 */

}
