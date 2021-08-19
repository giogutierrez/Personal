package com.gio.arquitectura.repository;

import org.springframework.data.repository.CrudRepository;

import com.gio.arquitectura.entity.ProductoEntity;

public interface IProductoRepository extends CrudRepository<ProductoEntity, Long>{

}
