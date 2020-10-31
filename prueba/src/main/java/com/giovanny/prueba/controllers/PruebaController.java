package com.giovanny.prueba.controllers;

import javax.validation.constraints.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.giovanny.prueba.DTO.EntradaSuma;

@RestController
@RequestMapping("/pruebaServicio")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
public class PruebaController {
	
	@GetMapping("test")
	public Long Calcula() {
		return 1L + 5L;
	}
	
	@PostMapping("suma")
	public Long Suma(@RequestBody EntradaSuma entrada) {
		
		Long suma = entrada.getNumeroUno() + entrada.getNumeroDos(); 
		
		return suma;
	}
}
