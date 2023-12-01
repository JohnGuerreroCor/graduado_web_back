package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Token;

public class TokenInternoRowMapper  implements RowMapper<Token> {
	
	@Override
	public Token mapRow(ResultSet rs, int rowNum) throws SQLException {
		Token tercero = new Token();
		tercero.setCodigo(rs.getInt("isg_codigo"));
		tercero.setModulo(rs.getInt("mod_codigo"));
		tercero.setId(rs.getString("id"));
		tercero.setToken(rs.getString("isg_token"));
		tercero.setIntento(rs.getInt("isg_intento"));
		tercero.setEstado(rs.getInt("cise_codigo"));
		tercero.setIp(rs.getString("isg_ip"));
		tercero.setFechaGeneracion(rs.getDate("isg_fecha_generacion"));
		tercero.setFechaExpiracion(rs.getDate("isg_fecha_expira"));
		tercero.setFechaFinSesion(rs.getDate("isg_fecha_fin_sesion"));
		
		return tercero;
	}

}