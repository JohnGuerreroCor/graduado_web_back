package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IExpectativaCapacitacionDao;
import com.usco.edu.entities.ExpectativaCapacitacionEscala;
import com.usco.edu.entities.ExpectativaCapacitacionPregunta;
import com.usco.edu.entities.ExpectativaCompetenciaRespuesta;
import com.usco.edu.resultSetExtractor.ExpectativaCapacitacionEscalaSetExtractor;
import com.usco.edu.resultSetExtractor.ExpectativaCapacitacionPreguntaSetExtractor;
import com.usco.edu.resultSetExtractor.ExpectativaCompetenciaRespuestaSetExtractor;

@Repository
public class ExpectativaCapacitacionDaoImpl implements IExpectativaCapacitacionDao {
	

	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ExpectativaCapacitacionPregunta> obtenerPregunta() {
		
		String sql = "select * from graduado.expectativas_capacitacion_pregunta ecp where ecp.ecp_estado = 1";
		return jdbcTemplate.query(sql, new ExpectativaCapacitacionPreguntaSetExtractor());
		
	}

	@Override
	public List<ExpectativaCapacitacionEscala> obtenerEscala(int preguntaCodigo) {
		
		String sql = "select * from graduado.expectativas_capacitacion_escala ece where ece.ecp_codigo = " + preguntaCodigo +" and ece.ece_estado = 1";
		return jdbcTemplate.query(sql, new ExpectativaCapacitacionEscalaSetExtractor());
		
	}

	@Override
	public List<ExpectativaCompetenciaRespuesta> obtenerRespuestasIdentificacion(String id) {
		
		String sql = "select ecr.ecr_codigo, ecr.per_codigo, ecr.ecp_codigo, ecp.ecp_nombre, ecr.ece_codigo, ece.ece_respuesta, ecr.ecr_fecha from academia3000_john.graduado.expectativas_capacitacion_respuesta ecr  "
				+ "left join persona p on ecr.per_codigo = p.per_codigo "
				+ "left join graduado.expectativas_capacitacion_pregunta ecp on ecr.ecp_codigo = ecp.ecp_codigo "
				+ "left join graduado.expectativas_capacitacion_escala ece on ecr.ece_codigo = ece.ece_codigo "
				+ "where p.per_identificacion = '" + id + "'";
		return jdbcTemplate.query(sql, new ExpectativaCompetenciaRespuestaSetExtractor());
		
	}

}
