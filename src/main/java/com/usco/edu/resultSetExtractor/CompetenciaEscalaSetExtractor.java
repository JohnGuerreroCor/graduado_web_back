package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CompetenciaEscala;
import com.usco.edu.rowMapper.CompetenciaEscalaRowMapper;

public class CompetenciaEscalaSetExtractor implements ResultSetExtractor<List<CompetenciaEscala>> {
	
	@Override
	public List<CompetenciaEscala> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CompetenciaEscala> list = new ArrayList<CompetenciaEscala>();
		while (rs.next()) {
			list.add(new CompetenciaEscalaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
