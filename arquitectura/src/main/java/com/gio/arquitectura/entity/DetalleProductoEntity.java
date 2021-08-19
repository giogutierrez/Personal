package com.gio.arquitectura.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Cacheable(false)
@Entity @Table(name = "detalle_producto", schema = "ejemplo")
public class DetalleProductoEntity {
	
    @Id
	@SequenceGenerator(name = "DETALLE_PRODUCTO_GENERATOR", sequenceName = "ejemplo.detalle_producto_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETALLE_PRODUCTO_GENERATOR")
    @Column(name = "id_detalle")
    private Long idDetalle;
    
	//@Column(name = "id_producto")
	//private Long idProducto;
	
	@Column(name = "caracteristica")
	private String caracteristica;
    
}
