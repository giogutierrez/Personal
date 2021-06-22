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
@Entity @Table(name = "estudiantes", schema = "ejemplo")
public class EstudiantesEntity {

    @Id
	@SequenceGenerator(name = "ESTUDIANTES_GENERATOR", sequenceName = "ejemplo.estudiantes_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTUDIANTES_GENERATOR")
    @Column(name = "id_estudiante")
    private Long idEstudiante;
   
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "identificacion")
	private String identificacion;
}
