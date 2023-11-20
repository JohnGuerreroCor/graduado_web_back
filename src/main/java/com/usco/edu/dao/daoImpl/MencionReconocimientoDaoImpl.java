package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IMencionReconocimientoDao;
import com.usco.edu.entities.Ambito;
import com.usco.edu.entities.MencionReconocimiento;
import com.usco.edu.resultSetExtractor.AmbitoSetExtractor;
import com.usco.edu.resultSetExtractor.MencionReconocimientoSetExtractor;

@Repository
public class MencionReconocimientoDaoImpl implements IMencionReconocimientoDao {
	

	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("JDBCTemplateEjecucion")
	public JdbcTemplate jdbcTemplateEjecucion;
	
	@Override
	public List<Ambito> obtenerAmbitos() {
		
		String sql = "select * from graduado.ambito a where a.amb_estado = 1";
		return jdbcTemplate.query(sql, new AmbitoSetExtractor());
		
	}

	@Override
	public List<MencionReconocimiento> obtenerMencionesReconocimiento(String id) {
		
		String sql = "select * from graduado.mencion_reconocimiento mr "
				+ "inner join persona p on mr.per_codigo = p.per_codigo "
				+ "inner join graduado.ambito a on mr.amb_codigo = a.amb_codigo "
				+ "inner join municipio m on mr.mun_codigo = m.mun_codigo "
				+ "inner join departamento d on m.dep_codigo = d.dep_codigo "
				+ "inner join pais pa on d.pai_codigo = pa.pai_codigo "
				+ "where p.per_identificacion = '" + id + "' and mr.mer_estado = 1";
		return jdbcTemplate.query(sql, new MencionReconocimientoSetExtractor());
		
	}

	@Override
	public List<MencionReconocimiento> obtenerReporteMencionesReconocimiento(String inicio, String fin) {
		
		String sql = "select * from graduado.mencion_reconocimiento mr "
				+ "inner join persona p on mr.per_codigo = p.per_codigo "
				+ "inner join graduado.ambito a on mr.amb_codigo = a.amb_codigo "
				+ "inner join municipio m on mr.mun_codigo = m.mun_codigo "
				+ "where convert(Date, mr.mer_fecha) between '" + inicio + "' and '" + fin + "' ";
		return jdbcTemplate.query(sql, new MencionReconocimientoSetExtractor());
		
	}

	@Override
	public int registrarMencionReconocimiento(MencionReconocimiento mencionReconocimiento) {
		
		String sql = "INSERT INTO graduado.mencion_reconocimiento "
				+ "(per_codigo, mer_institucion, mer_tipo, amb_codigo, mer_titulo, mer_descripcion, mun_codigo, mer_fecha) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				mencionReconocimiento.getPersonaCodigo(),
				mencionReconocimiento.getInstitucion(),
				mencionReconocimiento.getTipo(),
				mencionReconocimiento.getAmbitoCodigo(),
				mencionReconocimiento.getTitulo(),
				mencionReconocimiento.getDescripcion(),
				mencionReconocimiento.getMunicipioCodigo(),
				mencionReconocimiento.getFecha()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", mencionReconocimiento.getPersonaCodigo());
			parameter.addValue("institucion", mencionReconocimiento.getInstitucion());
			parameter.addValue("tipo", mencionReconocimiento.getTipo());
			parameter.addValue("ambito", mencionReconocimiento.getAmbitoCodigo());
			parameter.addValue("titulo", mencionReconocimiento.getTitulo());
			parameter.addValue("descripcion", mencionReconocimiento.getDescripcion());
			parameter.addValue("municipio", mencionReconocimiento.getMunicipioCodigo());
			parameter.addValue("fecha", mencionReconocimiento.getFecha());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int actualizarMencionReconocimiento(MencionReconocimiento mencionReconocimiento) {
		
		String sql = "UPDATE graduado.mencion_reconocimiento "
				+ "SET per_codigo=?, mer_institucion=?, mer_tipo=?, amb_codigo=?, mer_titulo=?, mer_descripcion=?, mun_codigo=?, mer_fecha=?, mer_estado=? "
				+ "WHERE mer_codigo=?;";

		int result = jdbcTemplateEjecucion.update(sql, new Object[] {
				mencionReconocimiento.getPersonaCodigo(),
				mencionReconocimiento.getInstitucion(),
				mencionReconocimiento.getTipo(),
				mencionReconocimiento.getAmbitoCodigo(),
				mencionReconocimiento.getTitulo(),
				mencionReconocimiento.getDescripcion(),
				mencionReconocimiento.getMunicipioCodigo(),
				mencionReconocimiento.getFecha(),
				mencionReconocimiento.getEstado(),
				mencionReconocimiento.getCodigo()
				});
		
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("personaCodigo", mencionReconocimiento.getPersonaCodigo());
			parameter.addValue("institucion", mencionReconocimiento.getInstitucion());
			parameter.addValue("tipo", mencionReconocimiento.getTipo());
			parameter.addValue("ambito", mencionReconocimiento.getAmbitoCodigo());
			parameter.addValue("titulo", mencionReconocimiento.getTitulo());
			parameter.addValue("descripcion", mencionReconocimiento.getDescripcion());
			parameter.addValue("municipio", mencionReconocimiento.getMunicipioCodigo());
			parameter.addValue("fecha", mencionReconocimiento.getFecha());
			parameter.addValue("estado", mencionReconocimiento.getEstado());
			parameter.addValue("codigo", mencionReconocimiento.getCodigo());
			
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		}
		
	}
	
}
