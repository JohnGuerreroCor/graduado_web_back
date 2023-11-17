package com.usco.edu.dao.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IGraduadoDao;
import com.usco.edu.entities.EstudianteActivo;
import com.usco.edu.entities.Graduado;
import com.usco.edu.resultSetExtractor.EstudianteActivoSetExtractor;
import com.usco.edu.resultSetExtractor.GraduadoSetExtractor;

@Repository
public class GraduadoDaoImpl implements IGraduadoDao{
	
	@Autowired
	@Qualifier("JDBCTemplatePlanesConsulta")
	public JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Graduado> buscarGraduadoPorIdentificacion(String id, String userdb) {

		String sql = "select *, floor((cast(convert(varchar(8),getdate(),112) as int) - cast(convert(varchar(8), p.per_fecha_nacimiento ,112) as int) ) / 10000) as edad from graduado g "
				+ "inner join estudiante e on g.est_codigo = e.est_codigo "
				+ "inner join persona p on e.per_codigo = p.per_codigo "
				+ "inner join grupo_sanguineo gs on p.grs_codigo = gs.grs_codigo "
				+ "inner join tipo_id ti on p.tii_codigo = ti.tii_codigo "
				+ "inner join programa pr on e.pro_codigo = pr.pro_codigo "
				+ "inner join nivel_academico na on pr.nia_codigo = na.nia_codigo "
				+ "inner join uaa u on pr.uaa_codigo = u.uaa_codigo "
				+ "inner join sede s on pr.sed_codigo = s.sed_codigo "
				+ "left join municipio m on p.per_lugar_expedicion = m.mun_codigo "
				+ "where p.per_identificacion  = '" + id +  "' order by g.gra_fecha desc ";
		return jdbcTemplate.query(sql, new GraduadoSetExtractor());
	}


	@Override
	public List<EstudianteActivo> buscarGraduadoEstudianteActivo(String codigo, String userdb) {
		
		String sql = "select * from usuario_general ug where ug.up = " + codigo + " and ug.istipo = 2 and ug.state = 1";
		
		return jdbcTemplate.query(sql, new EstudianteActivoSetExtractor());
		
	}

}
