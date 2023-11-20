package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.SituacionLaboralPregunta;
import com.usco.edu.rowMapper.SituacionLaboralPreguntaRowMapper;

public class SituacionLaboralPreguntaSetExtractor implements ResultSetExtractor<List<SituacionLaboralPregunta>> {
	
	@Override
	public List<SituacionLaboralPregunta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<SituacionLaboralPregunta> list = new ArrayList<SituacionLaboralPregunta>();
		while (rs.next()) {
			list.add(new SituacionLaboralPreguntaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
		
	}
}
