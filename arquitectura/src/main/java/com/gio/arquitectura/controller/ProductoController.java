package com.gio.arquitectura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.gio.arquitectura.dto.MensajeDTO;
import com.gio.arquitectura.dto.NuevoEstudianteDTO;
import com.gio.arquitectura.dto.NuevoProductoDTO;
import com.gio.arquitectura.entity.ProductoEntity;
import com.gio.arquitectura.service.ProductoService;

@RestController
@RequestMapping("/producto")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("nuevoProducto")
	public ResponseEntity<MensajeDTO> nuevoEstudiante(@RequestBody ProductoEntity producto) {
	//public ResponseEntity<MensajeDTO> nuevoEstudiante(@RequestBody NuevoProductoDTO producto) {
		return productoService.nuevoProducto(producto);
	}
	
	
	@PostMapping("modificaProducto")
	public ResponseEntity<MensajeDTO> modificaProducto(@RequestBody ProductoEntity producto) {
		return productoService.modificaProducto(producto);
	}

}
