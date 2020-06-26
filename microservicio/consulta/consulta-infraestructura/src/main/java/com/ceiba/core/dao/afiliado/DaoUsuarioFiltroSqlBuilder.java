package com.ceiba.core.dao.afiliado;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoUsuarioFiltro;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.SqlBuilder;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoFiltroUsuario;
import com.ceiba.core.modelo.DtoAfiliado;

@Component
public class DaoUsuarioFiltroSqlBuilder implements DaoUsuarioFiltro {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	private static final String CAMPO_FECHA_CREACION = "u.fecha_creacion";
	private static final String CAMPO_FECHA_CREACION_SIN_ALIAS = "fecha_creacion";
	private static final String CAMPO_ID = "u.id";
	private static final String CAMPO_NOMBRE = "u.nombre";
	private static final String CAMPO_CLAVE = "u.clave";

	@SqlStatement(namespace = "afiliado", value = "listar.sql")
	private String sqlBuilder;

	public DaoUsuarioFiltroSqlBuilder(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoAfiliado> filtroUsuario(DtoFiltroUsuario filtro) {

			return new SqlBuilder(sqlBuilder, new MapeoAfiliado(), customNamedParameterJdbcTemplate)
					.conIgual(filtro.getNombre(), CAMPO_NOMBRE).conGroupBy(CAMPO_ID).conGroupBy(CAMPO_NOMBRE)
					.conGroupBy(CAMPO_CLAVE).conGroupBy(CAMPO_FECHA_CREACION)
					.conMayorMenorIgual(filtro.getFechaCreacion(), CAMPO_FECHA_CREACION, true,
							CAMPO_FECHA_CREACION_SIN_ALIAS)
					.buildQuery();

	}

}

