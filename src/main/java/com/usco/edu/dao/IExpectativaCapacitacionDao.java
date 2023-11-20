package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCapacitacionPregunta;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;

public interface IExpectativaCapacitacionDao {
	
	public List<ExpectativaCapacitacionPregunta> obtenerPregunta();
	
	public List<ExpectativaCapacitacionEscala> obtenerEscala(int preguntaCodigo);
	
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(String id);
	
	public int registrarExpectativaCompetenciaRespuesta(ExpectativaCompetenciaRespuesta expectativaCompetenciaRespuesta);
	
	public int actualizarExpectativaCompetenciaRespuesta(ExpectativaCompetenciaRespuesta expectativaCompetenciaRespuesta);

}
