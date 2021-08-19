package com.gio.arquitectura.dto;

import lombok.Data;
import java.util.List;

@Data
public class NuevoProductoDTO {

	private String nombre;
	private List<DetalleProductoDTO> detalle;
	
}
