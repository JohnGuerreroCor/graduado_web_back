package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CompetenciaPregunta;

public class CompetenciaPreguntaRowMapper implements RowMapper<CompetenciaPregunta> {
	
	@Override
	public CompetenciaPregunta mapRow(ResultSet rs, int rowNum) throws SQLException {
		CompetenciaPregunta pregunta = new CompetenciaPregunta();
		pregunta.setCodigo(rs.getInt("cop_codigo"));
		pregunta.setTipo(rs.getInt("cot_codigo"));
		pregunta.setPregunta(rs.getString("cop_nombre"));
		pregunta.setOrden(rs.getInt("cop_estado"));
		pregunta.setEstado(rs.getInt("cop_estado"));
		return pregunta;
	}
}
