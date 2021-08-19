package com.gio.arquitectura.repository;

import org.springframework.data.repository.CrudRepository;

import com.gio.arquitectura.entity.DetalleProductoEntity;

public interface IDetalleProductoRepository extends CrudRepository<DetalleProductoEntity, Long>{

}
