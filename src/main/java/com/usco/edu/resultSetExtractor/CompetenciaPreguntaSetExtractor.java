package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CompetenciaPregunta;
import com.usco.edu.rowMapper.CompetenciaPreguntaRowMapper;

public class CompetenciaPreguntaSetExtractor implements ResultSetExtractor<List<CompetenciaPregunta>> {
	
	@Override
	public List<CompetenciaPregunta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CompetenciaPregunta> list = new ArrayList<CompetenciaPregunta>();
		while (rs.next()) {
			list.add(new CompetenciaPreguntaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
