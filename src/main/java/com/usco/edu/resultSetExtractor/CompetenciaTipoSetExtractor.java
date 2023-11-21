package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.CompetenciaTipo;
import com.usco.edu.rowMapper.CompetenciaTipoRowMapper;

public class CompetenciaTipoSetExtractor implements ResultSetExtractor<List<CompetenciaTipo>> {
	
	@Override
	public List<CompetenciaTipo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<CompetenciaTipo> list = new ArrayList<CompetenciaTipo>();
		while (rs.next()) {
			list.add(new CompetenciaTipoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
}
