package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCapacitacionPregunta;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;
import com.usco.edu.service.IExpectativaCapacitacionService;

@RestController
@RequestMapping(path = "expectativacapacitacion")
public class ExpectativaCapacitacionRestController {
	
	@Autowired
	IExpectativaCapacitacionService expectativaCapacitacionService;
	
	@GetMapping(path = "obtener-pregunta")
	public List<ExpectativaCapacitacionPregunta> obtenerPregunta() {
		
		return expectativaCapacitacionService.obtenerPregunta();
		
	}
	
	@GetMapping(path = "obtener-escala/{codigo}")
	public List<ExpectativaCapacitacionEscala> obtenerEscala(@PathVariable int codigo) {
		
		return expectativaCapacitacionService.obtenerEscala(codigo);
		
	}
	
	@GetMapping(path = "obtener-respuestas-identificacion/{id}")
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(@PathVariable String id) {
		
		return expectativaCapacitacionService.obtenerRespuestasIdentificacion(id);
		
	}
	
	@PutMapping(path = "registrar-expectativa-capacitacion")
	public int registrarHistorialAcademico(@RequestBody ExpectativaCompetenciaRespuesta expectativaCompetenciaRespuesta) {
		
		return expectativaCapacitacionService.registrarExpectativaCompetenciaRespuesta(expectativaCompetenciaRespuesta);
		
	}
	
	@PutMapping(path = "actualizar-expectativa-capacitacion")
	public int actualizarHistorialAcademico(@RequestBody ExpectativaCompetenciaRespuesta expectativaCompetenciaRespuesta) {
		
		return expectativaCapacitacionService.actualizarExpectativaCompetenciaRespuesta(expectativaCompetenciaRespuesta);
		
	}

}
