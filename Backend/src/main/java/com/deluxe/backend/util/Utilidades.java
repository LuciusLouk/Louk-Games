package com.deluxe.backend.util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utilidades {

	/**
	 * 
	 * @param tipo (foto de perfil, imagen producto, etc)
	 * @return Obtiene la ruta donde se guardará la imagen dentro del proyecto spring
	 */
	public Path obtenerRutaDeGuardado(char tipo) {
		/****** Genero un nombre único para el archivo que se guardará en la ruta ********/
		// Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();
        
        // Formatear la fecha y hora actual como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = now.format(formatter);
        
        // Generar un identificador único aleatorio
        String uniqueID = UUID.randomUUID().toString();
        
        // Concatenar la fecha y hora formateadas con el identificador único
        String uniqueName = formattedDateTime + "_" + uniqueID + ".png";
        
        /********************/
        switch(tipo) {
	        case 'a':{
	        	 // Crear una ruta para la carpeta donde se almacenarán las imágenes
	            Path directorioImagenes = Paths.get("src", "main", "resources", "static", "images", "perfil");
	            // Obtener la ruta completa del archivo
	            return directorioImagenes.resolve(uniqueName);
	        }
	        default:return null;
        }
	}
	
	/**
	 * @param base64
	 * @return Devuelve un texto en base 64 sin encabezado
	 */
	public String obtenerBase64SinEncabezado(String base64) {

        String base64SinEncabezado = "";
		int indexComa = base64.indexOf(","); // Encuentra la posición de la coma
        if (indexComa != -1) {
            base64SinEncabezado = base64.substring(indexComa + 1); // Obtiene la subcadena después de la coma
            System.out.println(base64SinEncabezado);
        } else {
            // Manejo de caso donde no se encuentra la coma
            System.out.println("El encabezado no está presente en el texto Base64.");
            base64SinEncabezado = base64;
        }
		return base64SinEncabezado;
	}
	
}
