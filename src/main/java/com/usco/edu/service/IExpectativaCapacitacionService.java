package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCapacitacionPregunta;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;

public interface IExpectativaCapacitacionService {
	
	public List<ExpectativaCapacitacionPregunta> obtenerPregunta();
	
	public List<ExpectativaCapacitacionEscala> obtenerEscala(int preguntaCodigo);
	
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(String id);

}
