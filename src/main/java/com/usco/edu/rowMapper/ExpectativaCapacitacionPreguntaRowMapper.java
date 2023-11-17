package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.ExpectativaCapacitacionPregunta;

public class ExpectativaCapacitacionPreguntaRowMapper implements RowMapper<ExpectativaCapacitacionPregunta> {
	
	@Override
	public ExpectativaCapacitacionPregunta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ExpectativaCapacitacionPregunta pregunta = new ExpectativaCapacitacionPregunta();
		pregunta.setCodigo(rs.getInt("ecp_codigo"));
		pregunta.setPregunta(rs.getString("ecp_nombre"));
		pregunta.setOrden(rs.getInt("ecp_orden"));
		pregunta.setEstado(rs.getInt("ecp_estado"));
		return pregunta;
		
	}
}
