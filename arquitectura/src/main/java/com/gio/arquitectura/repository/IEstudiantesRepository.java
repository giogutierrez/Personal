package com.gio.arquitectura.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gio.arquitectura.entity.EstudiantesEntity;

public interface IEstudiantesRepository extends CrudRepository<EstudiantesEntity, Long>{
	
	public List<EstudiantesEntity> findByIdentificacion(String identificacion);
}
