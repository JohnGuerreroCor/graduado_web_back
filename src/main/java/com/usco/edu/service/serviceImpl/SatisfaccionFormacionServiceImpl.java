package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ISatisfaccionFormacionDao;
import com.usco.edu.entities.CompetenciaEscala;
import com.usco.edu.entities.CompetenciaPregunta;
import com.usco.edu.entities.CompetenciaRespuesta;
import com.usco.edu.service.ISatisfaccionFormacionService;

@Service
public class SatisfaccionFormacionServiceImpl implements ISatisfaccionFormacionService {
	
	@Autowired
	private ISatisfaccionFormacionDao satisfaccionFormacionDao;

	@Override
	public List<CompetenciaPregunta> obtenerPregunta() {
		
		return satisfaccionFormacionDao.obtenerPregunta();
		
	}

	@Override
	public List<CompetenciaEscala> obtenerEscala(int preguntaCodigo) {
		
		return satisfaccionFormacionDao.obtenerEscala(preguntaCodigo);
		
	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(String id) {
		
		return satisfaccionFormacionDao.obtenerRespuestasTipoUnoIdentificacion(id);
		
	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(String id) {
		
		return satisfaccionFormacionDao.obtenerRespuestasTipoDosIdentificacion(id);
		
	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(String id) {
		
		return satisfaccionFormacionDao.obtenerRespuestasTipoTresIdentificacion(id);
		
	}

	@Override
	public int registrar(CompetenciaRespuesta competenciaRespuesta) {
		
		return satisfaccionFormacionDao.registrar(competenciaRespuesta);
		
	}

	@Override
	public int actualizar(CompetenciaRespuesta competenciaRespuesta) {
		
		return satisfaccionFormacionDao.actualizar(competenciaRespuesta);
		
	}

	
}
