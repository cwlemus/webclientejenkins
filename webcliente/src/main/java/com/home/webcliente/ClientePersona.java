package com.home.webcliente;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.home.dtos.PersonaDto;

@RestController
public class ClientePersona {
	@RequestMapping("/personascliente")
	public List<PersonaDto> listPersona(){		
		RestTemplate plantilla = new RestTemplate();
		ResponseEntity<PersonaDto[]> lista = plantilla.getForEntity("http://springservidor:8099/personas", PersonaDto[].class);
		PersonaDto[] nuevaLista = lista.getBody();
		return Arrays.asList(nuevaLista);
	}

}
