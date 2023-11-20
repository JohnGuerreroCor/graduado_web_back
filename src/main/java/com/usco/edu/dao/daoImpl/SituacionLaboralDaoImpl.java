package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.ISituacionLaboralDao;
import com.usco.edu.entities.SituacionLaboralEscala;
import com.usco.edu.entities.SituacionLaboralPregunta;
import com.usco.edu.entities.SituacionLaboralRespuesta;
import com.usco.edu.resultSetExtractor.SituacionLaboralEscalaSetExtractor;
import com.usco.edu.resultSetExtractor.SituacionLaboralPreguntaSetExtractor;
import com.usco.edu.resultSetExtractor.SituacionLaboralRespuestaSetExtractor;

@Repository
public class SituacionLaboralDaoImpl implements ISituacionLaboralDao {
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<SituacionLaboralPregunta> obtenerPregunta() {
		
		String sql = "select * from graduado.situacion_laboral_pregunta slp where slp.slp_estado = 1 order by slp.slp_orden asc";
		return jdbcTemplate.query(sql, new SituacionLaboralPreguntaSetExtractor());
		
	}

	@Override
	public List<SituacionLaboralEscala> obtenerEscala(int preguntaCodigo) {
		
		String sql = "select * from graduado.situacion_laboral_escala sle where sle.slp_codigo = " + preguntaCodigo + " and sle.sle_estado = 1";
		return jdbcTemplate.query(sql, new SituacionLaboralEscalaSetExtractor());
		
	}

	@Override
	public List<SituacionLaboralRespuesta> obtenerRespuestasIdentificacion(String id) {
		
		String sql = "select slr.slr_codigo, slr.per_codigo, slr.slp_codigo, slp.slp_nombre, slr.sle_codigo, sle.sle_respuesta, slr.slr_fecha from graduado.situacion_laboral_respuesta slr "
				+ "left join persona p on slr.per_codigo = p.per_codigo "
				+ "left join graduado.situacion_laboral_pregunta slp on slr.slp_codigo = slp.slp_codigo "
				+ "left join graduado.situacion_laboral_escala sle on slr.sle_codigo = sle.sle_codigo  "
				+ "where p.per_identificacion = '" + id + "'";
		return jdbcTemplate.query(sql, new SituacionLaboralRespuestaSetExtractor());
		
	}

	@Override
	public int registrar(SituacionLaboralRespuesta situacionLaboralRespuesta) {
		
		String sql = "INSERT INTO academia3000_john.graduado.situacion_laboral_respuesta "
				+ "(per_codigo, slp_codigo, sle_codigo) "
				+ "VALUES(?, ?, ?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				situacionLaboralRespuesta.getPersonaCodigo(),
				situacionLaboralRespuesta.getPreguntaCodigo(),
				situacionLaboralRespuesta.getRespuestaCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", situacionLaboralRespuesta.getPersonaCodigo());
			parameter.addValue("preguntaCodigo", situacionLaboralRespuesta.getPreguntaCodigo());
			parameter.addValue("respuestaCodigo", situacionLaboralRespuesta.getRespuestaCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int actualizar(SituacionLaboralRespuesta situacionLaboralRespuesta) {
		
		String sql = "UPDATE academia3000_john.graduado.situacion_laboral_respuesta "
				+ "SET per_codigo=?, slp_codigo=?, sle_codigo=?, slr_fecha=? "
				+ "WHERE slr_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				situacionLaboralRespuesta.getPersonaCodigo(),
				situacionLaboralRespuesta.getPreguntaCodigo(),
				situacionLaboralRespuesta.getRespuestaCodigo(),
				situacionLaboralRespuesta.getFechaRespuesta(),
				situacionLaboralRespuesta.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", situacionLaboralRespuesta.getPersonaCodigo());
			parameter.addValue("preguntaCodigo", situacionLaboralRespuesta.getPreguntaCodigo());
			parameter.addValue("respuestaCodigo", situacionLaboralRespuesta.getRespuestaCodigo());
			parameter.addValue("fecha", situacionLaboralRespuesta.getFechaRespuesta());
			parameter.addValue("codigo", situacionLaboralRespuesta.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}
	
}
