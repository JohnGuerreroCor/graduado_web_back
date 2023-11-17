package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IFormacionAcademicaDao;
import com.usco.edu.entities.HistorialAcademico;
import com.usco.edu.entities.NivelAcademico;
import com.usco.edu.resultSetExtractor.HistorialAcademicoSetExtractor;
import com.usco.edu.resultSetExtractor.NivelAcademicoSetExtractor;

@Repository
public class FormacionAcademicaDaoImpl implements IFormacionAcademicaDao{
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;

	@Override
	public List<NivelAcademico> obtenerNivelesAcademicos() {
		
		String sql = "select * from dbo.nivel_academico na where na.nia_estado = 1";
		
		return jdbcTemplate.query(sql, new NivelAcademicoSetExtractor());
		
	}

	@Override
	public List<HistorialAcademico> obtenerHistorialAcademico(String id) {
		
		String sql = "select * from graduado.historial_academico ha "
				+ "inner join persona p on ha.per_codigo = p.per_codigo "
				+ "inner join nivel_academico na on ha.nia_codigo = na.nia_codigo "
				+ "left join municipio m on ha.mun_codigo = m.mun_codigo "
				+ "left join departamento d on m.dep_codigo = d.dep_codigo "
				+ "left join pais pa on d.pai_codigo = pa.pai_codigo "
				+ "where p.per_identificacion = '" + id + "' and ha.hia_Estado = 1";
		
		return jdbcTemplate.query(sql, new HistorialAcademicoSetExtractor());
		
	}

	@Override
	public List<HistorialAcademico> obtenerReporteHistorialAcademico(String inicio, String fin) {
		
		String sql = "select * from graduado.historial_academico ha "
				+ "inner join persona p on ha.per_codigo = p.per_codigo "
				+ "inner join nivel_academico na on ha.nia_codigo = na.nia_codigo "
				+ "left join municipio m on ha.mun_codigo = m.mun_codigo "
				+ "left join departamento d on m.dep_codigo = d.dep_codigo "
				+ "left join pais pa on d.pai_codigo = pa.pai_codigo "
				+ "where convert(Date, ha.hia_fecha_fin) between '" + inicio + "' and '" + fin + "' ";
		
		return jdbcTemplate.query(sql, new HistorialAcademicoSetExtractor());
		
	}

	@Override
	public int registrarHistorialAcademico(HistorialAcademico historialAcademico) {
		
		String sql = "INSERT INTO graduado.historial_academico "
				+ "(per_codigo, hia_titulo, nia_codigo, hia_institucion, mun_codigo, hia_fecha_inicio, hia_fecha_fin, hia_finalizado) "
				+ "VALUES( ?, ?, ?, ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				historialAcademico.getPerCodigo(),
				historialAcademico.getTitulo(),
				historialAcademico.getNivelAcademicoCodigo(),
				historialAcademico.getInstitucion(),
				historialAcademico.getMunicipioCodigo(),
				historialAcademico.getFechaInicio(),
				historialAcademico.getFechaFin(),
				historialAcademico.getFinalizado()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", historialAcademico.getPerCodigo());
			parameter.addValue("titulo", historialAcademico.getTitulo());
			parameter.addValue("nivelAcademico", historialAcademico.getNivelAcademicoCodigo());
			parameter.addValue("institucion", historialAcademico.getInstitucion());
			parameter.addValue("municipio", historialAcademico.getMunicipioCodigo());
			parameter.addValue("fechaInicio", historialAcademico.getFechaInicio());
			parameter.addValue("fechaFin", historialAcademico.getFechaFin());
			parameter.addValue("finalizado", historialAcademico.getFinalizado());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int actualizarHistorialAcademico(HistorialAcademico historialAcademico) {
		
		String sql = "UPDATE academia3000_john.graduado.historial_academico "
				+ "SET per_codigo=?, hia_titulo=?, nia_codigo=?, hia_institucion=?, mun_codigo=?, hia_fecha_inicio=?, hia_fecha_fin=?, hia_finalizado=?, hia_estado=? "
				+ "WHERE hia_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				historialAcademico.getPerCodigo(),
				historialAcademico.getTitulo(),
				historialAcademico.getNivelAcademicoCodigo(),
				historialAcademico.getInstitucion(),
				historialAcademico.getMunicipioCodigo(),
				historialAcademico.getFechaInicio(),
				historialAcademico.getFechaFin(),
				historialAcademico.getFinalizado(),
				historialAcademico.getEstado(),
				historialAcademico.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", historialAcademico.getPerCodigo());
			parameter.addValue("titulo", historialAcademico.getTitulo());
			parameter.addValue("nivelAcademico", historialAcademico.getNivelAcademicoCodigo());
			parameter.addValue("institucion", historialAcademico.getInstitucion());
			parameter.addValue("municipio", historialAcademico.getMunicipioCodigo());
			parameter.addValue("fechaInicio", historialAcademico.getFechaInicio());
			parameter.addValue("fechaFin", historialAcademico.getFechaFin());
			parameter.addValue("finalizado", historialAcademico.getFinalizado());
			parameter.addValue("estado", historialAcademico.getEstado());
			parameter.addValue("codigo", historialAcademico.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}
}
