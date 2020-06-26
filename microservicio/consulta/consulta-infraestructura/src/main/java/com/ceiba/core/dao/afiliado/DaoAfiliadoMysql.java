package com.ceiba.core.dao.afiliado;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoAfiliado;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoAfiliado;

import org.springframework.cache.annotation.Cacheable;

@Component
public class DaoAfiliadoMysql implements DaoAfiliado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    
    @SqlStatement(namespace="afiliado", value="listar")
	private String sqlListar;

    public DaoAfiliadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
	@Cacheable("Afiliados")
	public List<DtoAfiliado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAfiliado());
    }
}