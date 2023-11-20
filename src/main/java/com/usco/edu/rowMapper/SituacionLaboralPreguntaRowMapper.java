package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.SituacionLaboralPregunta;

public class SituacionLaboralPreguntaRowMapper implements RowMapper<SituacionLaboralPregunta> {
	
	@Override
	public SituacionLaboralPregunta mapRow(ResultSet rs, int rowNum) throws SQLException {
		SituacionLaboralPregunta pregunta = new SituacionLaboralPregunta();
		pregunta.setCodigo(rs.getInt("slp_codigo"));
		pregunta.setPregunta(rs.getString("slp_nombre"));
		pregunta.setOrden(rs.getInt("slp_orden"));
		pregunta.setEstado(rs.getInt("slp_estado"));
		return pregunta;
	}
}
