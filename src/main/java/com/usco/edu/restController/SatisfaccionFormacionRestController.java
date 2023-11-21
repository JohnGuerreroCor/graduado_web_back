package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.CompetenciaEscala;
import com.usco.edu.entities.CompetenciaPregunta;
import com.usco.edu.entities.CompetenciaRespuesta;
import com.usco.edu.service.ISatisfaccionFormacionService;

@RestController
@RequestMapping(path = "satisfaccionformacion")
public class SatisfaccionFormacionRestController {
	
	@Autowired
	ISatisfaccionFormacionService satisfaccionFormacionService;
	
	@GetMapping(path = "obtener-pregunta")
	public List<CompetenciaPregunta> obtenerPregunta() {
		
		return satisfaccionFormacionService.obtenerPregunta();
		
	}
	
	@GetMapping(path = "obtener-escala/{codigo}")
	public List<CompetenciaEscala> obtenerEscala(@PathVariable int codigo) {
		
		return satisfaccionFormacionService.obtenerEscala(codigo);
		
	}
	
	@GetMapping(path = "obtener-respuestas-tipo-uno-identificacion/{id}")
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(@PathVariable String id) {
		
		return satisfaccionFormacionService.obtenerRespuestasTipoUnoIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-respuestas-tipo-dos-identificacion/{id}")
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(@PathVariable String id) {
		
		return satisfaccionFormacionService.obtenerRespuestasTipoDosIdentificacion(id);
		
	}
	
	@GetMapping(path = "obtener-respuestas-tipo-tres-identificacion/{id}")
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(@PathVariable String id) {
		
		return satisfaccionFormacionService.obtenerRespuestasTipoTresIdentificacion(id);
		
	}
	
	@PutMapping(path = "registrar-satisfaccion-formacion")
	public int registrar(@RequestBody CompetenciaRespuesta competenciaRespuesta) {
		
		return satisfaccionFormacionService.registrar(competenciaRespuesta);
		
	}
	
	@PutMapping(path = "actualizar-satisfaccion-formacion")
	public int actualizar(@RequestBody CompetenciaRespuesta competenciaRespuesta) {
		
		return satisfaccionFormacionService.actualizar(competenciaRespuesta);
		
	}

}
