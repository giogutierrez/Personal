package com.gio.arquitectura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gio.arquitectura.dto.DetalleProductoDTO;
import com.gio.arquitectura.dto.MensajeDTO;
import com.gio.arquitectura.dto.NuevoProductoDTO;
import com.gio.arquitectura.entity.DetalleProductoEntity;
import com.gio.arquitectura.entity.ProductoEntity;
import com.gio.arquitectura.repository.IDetalleProductoRepository;
import com.gio.arquitectura.repository.IProductoRepository;
import com.gio.arquitectura.util.Constantes;

@Service
public class ProductoService {

	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired 
	private IDetalleProductoRepository iDetalleProductoRepository;
	
	
	public ResponseEntity<MensajeDTO> nuevoProducto(ProductoEntity nuevoProducto)
	{
		MensajeDTO respuesta = new MensajeDTO();
		respuesta.setCodigo(Constantes.OK);
	
		
		iProductoRepository.save(nuevoProducto);
		
		
		
		
		
	/*	ProductoEntity producto = new ProductoEntity();
		
		producto.setNombre(nuevoProducto.getNombre());
		producto = iProductoRepository.save(producto);
		
		
		
		for(DetalleProductoDTO det: nuevoProducto.getDetalle()) {
			
			DetalleProductoEntity detalle = new DetalleProductoEntity();
			detalle.setIdProducto(producto.getIdProducto());
			
			detalle.setCaracteristica(det.getCaracteristica());
			iDetalleProductoRepository.save(detalle);
		}
		*/
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<MensajeDTO> modificaProducto(ProductoEntity modificaProducto)
	{
		MensajeDTO respuesta = new MensajeDTO();
		respuesta.setCodigo(Constantes.OK);
		
		iProductoRepository.save(modificaProducto);

		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
}
