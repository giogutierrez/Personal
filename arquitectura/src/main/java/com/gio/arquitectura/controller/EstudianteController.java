package com.gio.arquitectura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import com.gio.arquitectura.service.EstudianteService;
import com.gio.arquitectura.dto.ConsultaEstudianteDTO;
import com.gio.arquitectura.dto.MensajeDTO;
import com.gio.arquitectura.dto.NuevoEstudianteDTO;

@RestController
@RequestMapping("/estudiante")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
public class EstudianteController {
	
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("test")
	public String test() {
		return estudianteService.test();	
	}
	
	@PostMapping("nuevoEstudiante")
	public ResponseEntity<MensajeDTO> nuevoEstudiante(@RequestBody NuevoEstudianteDTO estudiante) {
		return estudianteService.nuevoEstudiante(estudiante);	
	}
	
	@PostMapping("consultaEstudiante")
	public ResponseEntity<MensajeDTO> consultaEstudiante(@RequestBody ConsultaEstudianteDTO estudiante) {
		return estudianteService.consultaEstudiante(estudiante);	
	}
	
	
}
