package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Ambito;

public class AmbitoRowMapper implements RowMapper<Ambito> {
	
	@Override
	public Ambito mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ambito ambito = new Ambito();
		ambito.setCodigo(rs.getInt("amb_codigo"));
		ambito.setNombre(rs.getString("amb_nombre"));
		ambito.setCodigo(rs.getInt("amb_estado"));
		return ambito;
	}
}
