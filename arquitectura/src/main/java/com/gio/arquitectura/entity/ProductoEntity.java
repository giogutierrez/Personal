package com.gio.arquitectura.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Cacheable(false)
@Entity @Table(name = "producto", schema = "ejemplo")
public class ProductoEntity {
	
    @Id
	@SequenceGenerator(name = "PRODUCTO_GENERATOR", sequenceName = "ejemplo.producto_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTO_GENERATOR")
    @Column(name = "id_producto")
    private Long idProducto;
   
	@Column(name = "nombre")
	private String nombre;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
	private List<DetalleProductoEntity> detalle = new ArrayList<>();
	

}
