package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.CompetenciaEscala;
import com.usco.edu.entities.CompetenciaPregunta;
import com.usco.edu.entities.CompetenciaRespuesta;

public interface ISatisfaccionFormacionService {
	
	public List<CompetenciaPregunta> obtenerPregunta();
	
	public List<CompetenciaEscala> obtenerEscala(int preguntaCodigo);
	
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(String id);
	
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(String id);
	
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(String id);
	
	public int registrar(CompetenciaRespuesta competenciaRespuesta);
	
	public int actualizar(CompetenciaRespuesta competenciaRespuesta);

}
