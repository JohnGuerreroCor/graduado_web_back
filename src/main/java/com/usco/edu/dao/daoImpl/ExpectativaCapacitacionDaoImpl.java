package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
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
		
		String sql = "select ecr.ecr_codigo, ecr.per_codigo, ecr.ecp_codigo, ecp.ecp_nombre, ecr.ece_codigo, ece.ece_respuesta, ecr.ecr_fecha from graduado.expectativas_capacitacion_respuesta ecr  "
				+ "left join persona p on ecr.per_codigo = p.per_codigo "
				+ "left join graduado.expectativas_capacitacion_pregunta ecp on ecr.ecp_codigo = ecp.ecp_codigo "
				+ "left join graduado.expectativas_capacitacion_escala ece on ecr.ece_codigo = ece.ece_codigo "
				+ "where p.per_identificacion = '" + id + "' order by ecr.ecp_codigo asc";
		return jdbcTemplate.query(sql, new ExpectativaCompetenciaRespuestaSetExtractor());
		
	}

	@Override
	public int registrarExpectativaCompetenciaRespuesta(
			ExpectativaCompetenciaRespuesta expectativaCompetenciaRespuesta) {
		
		String sql = "INSERT INTO graduado.expectativas_capacitacion_respuesta "
				+ "(per_codigo, ecp_codigo, ece_codigo) "
				+ "VALUES(?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				expectativaCompetenciaRespuesta.getPersonaCodigo(),
				expectativaCompetenciaRespuesta.getPreguntaCodigo(),
				expectativaCompetenciaRespuesta.getRespuestaCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", expectativaCompetenciaRespuesta.getPersonaCodigo());
			parameter.addValue("preguntaCodigo", expectativaCompetenciaRespuesta.getPreguntaCodigo());
			parameter.addValue("respuestaCodigo", expectativaCompetenciaRespuesta.getRespuestaCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int actualizarExpectativaCompetenciaRespuesta(
			ExpectativaCompetenciaRespuesta expectativaCompetenciaRespuesta) {
		
		String sql = "UPDATE graduado.expectativas_capacitacion_respuesta "
				+ "SET per_codigo=?, ecp_codigo=?, ece_codigo=?, ecr_fecha=? "
				+ "WHERE ecr_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				expectativaCompetenciaRespuesta.getPersonaCodigo(),
				expectativaCompetenciaRespuesta.getPreguntaCodigo(),
				expectativaCompetenciaRespuesta.getRespuestaCodigo(),
				expectativaCompetenciaRespuesta.getFechaRespuesta(),
				expectativaCompetenciaRespuesta.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", expectativaCompetenciaRespuesta.getPersonaCodigo());
			parameter.addValue("preguntaCodigo", expectativaCompetenciaRespuesta.getPreguntaCodigo());
			parameter.addValue("respuestaCodigo", expectativaCompetenciaRespuesta.getRespuestaCodigo());
			parameter.addValue("fecha", expectativaCompetenciaRespuesta.getFechaRespuesta());
			parameter.addValue("codigo", expectativaCompetenciaRespuesta.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

}
