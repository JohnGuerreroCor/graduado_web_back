package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.CompetenciaTipo;

public class CompetenciaTipoRowMapper implements RowMapper<CompetenciaTipo> {
	
	@Override
	public CompetenciaTipo mapRow(ResultSet rs, int rowNum) throws SQLException {
		CompetenciaTipo tipo = new CompetenciaTipo();
		tipo.setCodigo(rs.getInt("cot_codigo"));
		tipo.setNombre(rs.getString("cot_nombre"));
		tipo.setEstado(rs.getInt("cot_estado"));
		return tipo;
	}
}
