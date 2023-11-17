package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.ExpectativaCapacitacionPregunta;
import com.usco.edu.rowMapper.ExpectativaCapacitacionPreguntaRowMapper;

public class ExpectativaCapacitacionPreguntaSetExtractor  implements ResultSetExtractor<List<ExpectativaCapacitacionPregunta>> {
	
	@Override
	public List<ExpectativaCapacitacionPregunta> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<ExpectativaCapacitacionPregunta> list = new ArrayList<ExpectativaCapacitacionPregunta>();
		while (rs.next()) {
			list.add(new ExpectativaCapacitacionPreguntaRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
	
}
