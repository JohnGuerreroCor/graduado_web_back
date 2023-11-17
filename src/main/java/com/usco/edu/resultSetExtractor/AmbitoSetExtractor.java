package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.Ambito;
import com.usco.edu.rowMapper.AmbitoRowMapper;

public class AmbitoSetExtractor implements ResultSetExtractor<List<Ambito>>{

	@Override
	public List<Ambito> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Ambito> list = new ArrayList<Ambito>();
		while (rs.next()) {
			list.add(new AmbitoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		
		return list;
	}
}
