package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IMencionReconocimientoDao;
import com.usco.edu.entities.Ambito;
import com.usco.edu.entities.MencionReconocimiento;
import com.usco.edu.service.IMencionReconocimientoService;

@Service
public class MencionReconocimientoServiceImpl implements IMencionReconocimientoService {
	
	@Autowired
	private IMencionReconocimientoDao mencionReconocimientoDao;
	
	@Override
	public List<Ambito> obtenerAmbitos() {
		
		return mencionReconocimientoDao.obtenerAmbitos();
		
	}

	@Override
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(String id) {
		
		return mencionReconocimientoDao.obtenerMencionesReconocimiento(id);
		
	}

	@Override
	public List<MencionReconocimiento> obtenerReporteMencionesReconocimiento(String inicio, String fin) {
		
		return mencionReconocimientoDao.obtenerReporteMencionesReconocimiento(inicio, fin);
		
	}

	@Override
	public int registrarMencionReconocimiento(MencionReconocimiento mencionReconocimiento) {
		
		return mencionReconocimientoDao.registrarMencionReconocimiento(mencionReconocimiento);
		
	}

	@Override
	public int actualizarMencionReconocimiento(MencionReconocimiento mencionReconocimiento) {
		
		return mencionReconocimientoDao.actualizarMencionReconocimiento(mencionReconocimiento);
		
	}

}
