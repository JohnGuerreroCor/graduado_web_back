package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.SituacionLaboralEscala;
import com.usco.edu.rowMapper.SituacionLaboralEscalaRowMapper;

public class SituacionLaboralEscalaSetExtractor implements ResultSetExtractor<List<SituacionLaboralEscala>> {
	
	@Override
	public List<SituacionLaboralEscala> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<SituacionLaboralEscala> list = new ArrayList<SituacionLaboralEscala>();
		while (rs.next()) {
			list.add(new SituacionLaboralEscalaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
		
	}
}
