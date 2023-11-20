package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.ISituacionLaboralDao;
import com.usco.edu.entities.SituacionLaboralEscala;
import com.usco.edu.entities.SituacionLaboralPregunta;
import com.usco.edu.entities.SituacionLaboralRespuesta;
import com.usco.edu.service.ISituacionLaboralService;

@Service
public class SituacionLaboralServiceImpl implements ISituacionLaboralService {
	
	@Autowired
	private ISituacionLaboralDao situacionLaboralDao;

	@Override
	public List<SituacionLaboralPregunta> obtenerPregunta() {
		
		return situacionLaboralDao.obtenerPregunta();
		
	}

	@Override
	public List<SituacionLaboralEscala> obtenerEscala(int preguntaCodigo) {
		
		return situacionLaboralDao.obtenerEscala(preguntaCodigo);
		
	}

	@Override
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(String id) {
		
		return situacionLaboralDao.obtenerRespuestasIdentificacion(id);
		
	}

	@Override
	public int registrar(SituacionLaboralRespuesta situacionLaboralRespuesta) {
		
		return situacionLaboralDao.registrar(situacionLaboralRespuesta);
		
	}

	@Override
	public int actualizar(SituacionLaboralRespuesta situacionLaboralRespuesta) {
		
		return situacionLaboralDao.actualizar(situacionLaboralRespuesta);
		
	}


	
}
