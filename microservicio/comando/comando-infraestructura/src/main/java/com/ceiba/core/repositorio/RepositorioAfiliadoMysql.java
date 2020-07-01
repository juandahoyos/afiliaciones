package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.afiliado.Afiliado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;

import java.util.List;

@Repository
public class RepositorioAfiliadoMysql implements RepositorioAfiliado {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
		
	@SqlStatement(namespace="afiliado", value="crearAfiliado")
	private static String sqlCrearAfiliado;
	
	@SqlStatement(namespace="afiliado", value="actualizarAfiliado")
	private static String sqlActualizarAfiliado;
	
	@SqlStatement(namespace="afiliado", value="eliminarAfiliado")
	private static String sqlEliminarAfiliado;
	
	@SqlStatement(namespace="afiliado", value="existeAfiliadoDocumento")
	private static String sqlExisteAfiliadoDocumento;

	@SqlStatement(namespace="afiliado", value="existeAfiliado")
	private static String sqlExisteAfiliado;
	
	public RepositorioAfiliadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Afiliado afiliado) {
		return this.customNamedParameterJdbcTemplate.crear(afiliado, sqlCrearAfiliado);
	}

    @Override
    public void eliminar(Long idAfiliado) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("idAfiliado", idAfiliado);
	    
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarAfiliado, paramSource);
    }

	@Override
	public boolean existe(String documento) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("documento", documento);

		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteAfiliadoDocumento,paramSource, Boolean.class);
	}

	@Override
	public List<Integer> existeAfiliado(int idAfiliado) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("idAfiliado", idAfiliado);
		return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForList(sqlExisteAfiliado,
				paramSource, Integer.class);
	}

	@Override
	public void actualizar(Afiliado afiliado) {
		this.customNamedParameterJdbcTemplate.actualizar(afiliado, sqlActualizarAfiliado);
	}
}
