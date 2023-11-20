package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.SituacionLaboralEscala;
import com.usco.edu.entities.SituacionLaboralPregunta;
import com.usco.edu.entities.SituacionLaboralRespuesta;
import com.usco.edu.service.ISituacionLaboralService;

@RestController
@RequestMapping(path = "situacionlaboral")
public class SituacionLaboralRestController {
	
	@Autowired
	ISituacionLaboralService situacionLaboralService;
	
	@GetMapping(path = "obtener-pregunta")
	public List<SituacionLaboralPregunta> obtenerPregunta() {
		
		return situacionLaboralService.obtenerPregunta();
		
	}
	
	@GetMapping(path = "obtener-escala/{codigo}")
	public List<SituacionLaboralEscala> obtenerEscala(@PathVariable int codigo) {
		
		return situacionLaboralService.obtenerEscala(codigo);
		
	}
	
	@GetMapping(path = "obtener-respuestas-identificacion/{id}")
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(@PathVariable String id) {
		
		return situacionLaboralService.obtenerRespuestasIdentificacion(id);
		
	}
	
	@PutMapping(path = "registrar-situacion-laboral")
	public int registrar(@RequestBody SituacionLaboralRespuesta situacionLaboralRespuesta) {
		
		return situacionLaboralService.registrar(situacionLaboralRespuesta);
		
	}
	
	@PutMapping(path = "actualizar-situacion-laboral")
	public int actualizar(@RequestBody SituacionLaboralRespuesta situacionLaboralRespuesta) {
		
		return situacionLaboralService.actualizar(situacionLaboralRespuesta);
		
	}

}
