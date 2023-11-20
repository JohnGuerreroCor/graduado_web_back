package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.SituacionLaboralEscala;
import com.usco.edu.entities.SituacionLaboralPregunta;
import com.usco.edu.entities.SituacionLaboralRespuesta;

public interface ISituacionLaboralDao {
	
	public List<SituacionLaboralPregunta> obtenerPregunta();
	
	public List<SituacionLaboralEscala> obtenerEscala(int preguntaCodigo);
	
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(String id);
	
	public int registrar(SituacionLaboralRespuesta situacionLaboralRespuesta);
	
	public int actualizar(SituacionLaboralRespuesta situacionLaboralRespuesta);

}
