package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.SituacionLaboralEscala;

public class SituacionLaboralEscalaRowMapper implements RowMapper<SituacionLaboralEscala> {
	
	@Override
	public SituacionLaboralEscala mapRow(ResultSet rs, int rowNum) throws SQLException {
		SituacionLaboralEscala respuesta = new SituacionLaboralEscala();
		respuesta.setCodigo(rs.getInt("sle_codigo"));
		respuesta.setPreguntaCodigo(rs.getInt("slp_codigo"));
		respuesta.setRespuesta(rs.getString("sle_respuesta"));
		respuesta.setEstado(rs.getInt("sle_Estado"));
		return respuesta;
	}
}
