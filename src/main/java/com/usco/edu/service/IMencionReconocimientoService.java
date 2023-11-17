package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.Ambito;
import com.usco.edu.entities.MencionReconocimiento;

public interface IMencionReconocimientoService {
	
	public List<Ambito> obtenerAmbitos();
	
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(String id);
	
	public List<MencionReconocimiento> obtenerReporteMencionesReconocimiento(String inicio, String fin);
	
	public int registrarMencionReconocimiento(MencionReconocimiento mencionReconocimiento);
	
	public int actualizarMencionReconocimiento(MencionReconocimiento mencionReconocimiento);

}
