package com.gio.arquitectura.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gio.arquitectura.dto.ConsultaEstudianteDTO;
import com.gio.arquitectura.dto.MensajeDTO;
import com.gio.arquitectura.dto.NuevoEstudianteDTO;
import com.gio.arquitectura.entity.EstudiantesEntity;
import com.gio.arquitectura.repository.IEstudiantesRepository;
import com.gio.arquitectura.util.Constantes;

@Service
public class EstudianteService {
	
	private static final Logger LOGGER = Logger.getLogger(EstudianteService.class.getSimpleName());
	
	@Autowired
	private IEstudiantesRepository iEstudiantesRepository;
	
	public String test() {
		LOGGER.info(Constantes.MENSAJE_PRUEBA);
		return Constantes.OK;
	}
	
	
	public ResponseEntity<MensajeDTO> nuevoEstudiante(NuevoEstudianteDTO estudiante){
		MensajeDTO respuesta = new MensajeDTO();
		respuesta.setCodigo(Constantes.OK);
		
		if(estudiante.getIdentificacion() == null  || estudiante.getNombre() == null) {
			respuesta.setCodigo(Constantes.ERROR);
			respuesta.setMensaje(Constantes.OBJETO_MAL_FORMADO);
			return new ResponseEntity<>(respuesta, HttpStatus.CONFLICT);
		}
		
		try {
			iEstudiantesRepository.save(armaEstudiante(estudiante));
			respuesta.setMensaje(Constantes.SAVE_ESTUDIANTE);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.severe(Constantes.ERROR_SAVE_ESTUDIANTE);
			respuesta.setCodigo(Constantes.ERROR);
			respuesta.setMensaje(Constantes.ERROR_SAVE_ESTUDIANTE);
			return new ResponseEntity<>(respuesta, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<MensajeDTO> consultaEstudiante(ConsultaEstudianteDTO estudiante){
		MensajeDTO respuesta = new MensajeDTO();
		respuesta.setCodigo(Constantes.OK);
		
		if( estudiante.getIdentificacion() == null) {
			respuesta.setCodigo(Constantes.ERROR);
			respuesta.setMensaje(Constantes.OBJETO_MAL_FORMADO);
			return new ResponseEntity<>(respuesta, HttpStatus.CONFLICT);
		}
		
		
		List<EstudiantesEntity> consultaEstudiante = new ArrayList<EstudiantesEntity>();
		consultaEstudiante = iEstudiantesRepository.findByIdentificacion(estudiante.getIdentificacion());
		
		if(consultaEstudiante.size() == 0) {
			respuesta.setCodigo(Constantes.ERROR);
			respuesta.setMensaje(Constantes.SIN_DATOS);
		}else {
			respuesta.setObjeto(consultaEstudiante);
		}
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
	
	
	
	
	// se puede sacar con mapper
	public EstudiantesEntity armaEstudiante(NuevoEstudianteDTO estudiante) {
		
        EstudiantesEntity nuevoEstudiante = new EstudiantesEntity();
		
		nuevoEstudiante.setIdentificacion(estudiante.getIdentificacion());
		nuevoEstudiante.setNombre(estudiante.getNombre());
		
		return nuevoEstudiante;
	} 
	
	
}
