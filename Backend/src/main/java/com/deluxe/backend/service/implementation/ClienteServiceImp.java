package com.deluxe.backend.service.implementation;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deluxe.backend.model.Cliente;
import com.deluxe.backend.repository.IClienteRepository;
import com.deluxe.backend.service.IClienteService;
import com.deluxe.backend.util.Utilidades;

@Service
public class ClienteServiceImp implements IClienteService {

	@Autowired
	IClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente getByID(Long id) {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id).get();
	}

	@Override
	public Cliente getEmpty() {
		// TODO Auto-generated method stub
		return new Cliente();
	}

	
	/**
	 * Registra un cliente con foto de perfil, guardando antes la foto de perfil que viene en formato
	 * base 64.
	 * Llama a los métodos: 
	 *  - obtenerRutaDeGuardado()
	 *  - obtenerBase64SinEncabezado(String base64)
	 */
	@Override
	public Cliente setObject(Cliente o) {
		//Cliente trae como foto de perfil un texto en base64
		/******************/
		//Antes de guardar debo cambiar el base64 por la ruta donde se guardará la imagen
		String base64=o.getCuenta().getFotoPerfil();
		//decodifico el texto en base64 a bytes (procuro quitarle el encabezado)
		byte[] bytesDecodificados = Base64.decodeBase64(Utilidades.obtenerBase64SinEncabezado(base64));
		
		//Convierto el texto decodificado en un string ?????????? no se usa?
        //String textoDecodificado = new String(bytesDecodificados);
        /*****************/
        
        /******* Crear la imagen en proyecto *********/
        Path rutaCompleta = Utilidades.obtenerRutaDeGuardado('a');
        try (OutputStream stream = Files.newOutputStream(rutaCompleta)) {
            stream.write(bytesDecodificados);
            System.out.println("Imagen guardada en: " + rutaCompleta);
        } catch (IOException e) {
            System.err.println("Error al guardar la imagen: " + e.getMessage());
        }
        /**************/
        //establecer foto de perfil en cuenta y guardar cliente
        o.getCuenta().setFotoPerfil(rutaCompleta.toString());
		return clienteRepository.save(o);
	}
	
	
	@Override
	public void modObject(Cliente o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delObject(Long id) {
		// TODO Auto-generated method stub

	}

}
