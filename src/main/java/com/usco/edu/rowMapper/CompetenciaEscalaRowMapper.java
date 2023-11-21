package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CompetenciaEscala;

public class CompetenciaEscalaRowMapper implements RowMapper<CompetenciaEscala> {
	
	@Override
	public CompetenciaEscala mapRow(ResultSet rs, int rowNum) throws SQLException {
		CompetenciaEscala escala = new CompetenciaEscala();
		escala.setCodigo(rs.getInt("coe_codigo"));
		escala.setNombre(rs.getString("coe_nombre"));
		escala.setEstado(rs.getInt("coe_estado"));
		return escala;
	}
}
