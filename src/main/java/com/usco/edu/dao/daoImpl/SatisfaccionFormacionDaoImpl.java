package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ISatisfaccionFormacionDao;
import com.usco.edu.entities.CompetenciaEscala;
import com.usco.edu.entities.CompetenciaPregunta;
import com.usco.edu.entities.CompetenciaRespuesta;
import com.usco.edu.resultSetExtractor.CompetenciaEscalaSetExtractor;
import com.usco.edu.resultSetExtractor.CompetenciaPreguntaSetExtractor;
import com.usco.edu.resultSetExtractor.CompetenciaRespuestaSetExtractor;

@Repository
public class SatisfaccionFormacionDaoImpl implements ISatisfaccionFormacionDao {
	

	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<CompetenciaPregunta> obtenerPregunta() {
		
		String sql = "select * from graduado.competencia_pregunta cp where cp.cop_estado = 1 order by cp.cop_orden asc";
		
		return jdbcTemplate.query(sql, new CompetenciaPreguntaSetExtractor());
		
	}

	@Override
	public List<CompetenciaEscala> obtenerEscala(int competenciaTipo) {
		
		String sql = "select * from graduado.competencia_escala ce where ce.coe_codigo > " + competenciaTipo;
		
		return jdbcTemplate.query(sql, new CompetenciaEscalaSetExtractor());
		
	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoUnoIdentificacion(String id) {
		
		String sql = "select * from graduado.competencia_respuesta cr "
				+ "inner join persona p on cr.per_codigo = p.per_codigo "
				+ "inner join graduado.competencia_pregunta cp on cr.cop_codigo = cp.cop_codigo "
				+ "inner join graduado.competencia_escala ce on cr.coe_codigo = ce.coe_codigo "
				+ "where p.per_identificacion = '" + id + "' order by cp.cop_orden asc";
		
		return jdbcTemplate.query(sql, new CompetenciaRespuestaSetExtractor());
		
	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoDosIdentificacion(String id) {
		
		String sql = "select * from graduado.competencia_respuesta cr "
				+ "inner join persona p on cr.per_codigo = p.per_codigo "
				+ "inner join graduado.competencia_pregunta cp on cr.cop_codigo = cp.cop_codigo "
				+ "inner join graduado.competencia_escala ce on cr.coe_codigo = ce.coe_codigo "
				+ "where p.per_identificacion = '" + id + "' and cp.cot_codigo = 3 order by cp.cop_orden ";
		
		return jdbcTemplate.query(sql, new CompetenciaRespuestaSetExtractor());
		
	}

	@Override
	public List<CompetenciaRespuesta> obtenerRespuestasTipoTresIdentificacion(String id) {
		
		String sql = "select * from graduado.competencia_respuesta cr "
				+ "inner join persona p on cr.per_codigo = p.per_codigo "
				+ "inner join graduado.competencia_pregunta cp on cr.cop_codigo = cp.cop_codigo "
				+ "inner join graduado.competencia_escala ce on cr.coe_codigo = ce.coe_codigo "
				+ "where p.per_identificacion = '" + id + "' and cp.cot_codigo = 3 order by cp.cop_orden ";
		
		return jdbcTemplate.query(sql, new CompetenciaRespuestaSetExtractor());
		
	}

	@Override
	public int registrar(CompetenciaRespuesta competenciaRespuesta) {
		
		String sql = "INSERT INTO graduado.competencia_respuesta "
				+ "(per_codigo, cop_codigo, coe_codigo) "
				+ "VALUES(?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				competenciaRespuesta.getPersonaCodigo(),
				competenciaRespuesta.getPreguntaCodigo(),
				competenciaRespuesta.getRespuestaCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", competenciaRespuesta.getPersonaCodigo());
			parameter.addValue("preguntaCodigo", competenciaRespuesta.getPreguntaCodigo());
			parameter.addValue("respuestaCodigo", competenciaRespuesta.getRespuestaCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int actualizar(CompetenciaRespuesta competenciaRespuesta) {
		
		String sql = "UPDATE graduado.competencia_respuesta "
				+ "SET per_codigo=?, cop_codigo=?, coe_codigo=?, cor_fecha=? "
				+ "WHERE cor_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				competenciaRespuesta.getPersonaCodigo(),
				competenciaRespuesta.getPreguntaCodigo(),
				competenciaRespuesta.getRespuestaCodigo(),
				competenciaRespuesta.getFechaRespuesta(),
				competenciaRespuesta.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", competenciaRespuesta.getPersonaCodigo());
			parameter.addValue("preguntaCodigo", competenciaRespuesta.getPreguntaCodigo());
			parameter.addValue("respuestaCodigo", competenciaRespuesta.getRespuestaCodigo());
			parameter.addValue("fecha", competenciaRespuesta.getFechaRespuesta());
			parameter.addValue("codigo", competenciaRespuesta.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	
}
