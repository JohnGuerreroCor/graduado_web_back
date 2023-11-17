package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IExpectativaCapacitacionDao;
import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCapacitacionPregunta;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;
import com.usco.edu.service.IExpectativaCapacitacionService;

@Service
public class ExpectativaCapacitacionServiceImpl implements IExpectativaCapacitacionService {
	
	@Autowired
	private IExpectativaCapacitacionDao expectativaCapacitacionDao;
	
	@Override
	public List<ExpectativaCapacitacionPregunta> obtenerPregunta() {
		
		return expectativaCapacitacionDao.obtenerPregunta();
		
	}

	@Override
	public List<ExpectativaCapacitacionEscala> obtenerEscala(int preguntaCodigo) {
		
		return expectativaCapacitacionDao.obtenerEscala(preguntaCodigo);
		
	}

	@Override
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(String id) {
		
		return expectativaCapacitacionDao.obtenerRespuestasIdentificacion(id);
		
	}
	
}
