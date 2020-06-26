package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.afiliado.Afiliado;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;

@Repository
public class RepositorioAfiliadoMysql implements RepositorioAfiliado {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
		
	@SqlStatement(namespace="afiliado", value="crear")
	private static String sqlCrear;
	
	@SqlStatement(namespace="afiliado", value="actualizar")
	private static String sqlActualizar;
	
	@SqlStatement(namespace="afiliado", value="eliminar")
	private static String sqlEliminar;
	
	@SqlStatement(namespace="afiliado", value="existe")
	private static String sqlExiste;
	
	@SqlStatement(namespace="afiliado", value="existeExcluyendoId")
	private static String sqlExisteExcluyendoId;
	
	public RepositorioAfiliadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Afiliado afiliado) {
		return this.customNamedParameterJdbcTemplate.crear(afiliado, sqlCrear);
	}

    @Override
    public void eliminar(Long id) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("id", id);
	    
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

	@Override
	public boolean existe(String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
	    paramSource.addValue("nombre", nombre);
	    
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
	}

	@Override
	public void actualizar(Afiliado afiliado) {
		this.customNamedParameterJdbcTemplate.actualizar(afiliado, sqlActualizar);
	}

	@Override
	public boolean existeExcluyendoId(Long id, String nombre) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
	    paramSource.addValue("nombre", nombre);
	    
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
	}
}
