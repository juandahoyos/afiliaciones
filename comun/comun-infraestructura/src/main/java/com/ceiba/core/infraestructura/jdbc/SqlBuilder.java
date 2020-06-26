package com.ceiba.core.infraestructura.jdbc;


import java.util.List;
import java.util.Map;
 
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
 
public class SqlBuilder {
 
	
	
	private static final String WHERE_REEMPLAZO = "<where>";
	private static final String IGUAL = " = ";
	private static final String IN = " IN ";
	private static final String IS_NOT_NULL = " IS NOT NULL ";
	private static final String IS_NULL = " IS NULL ";
	private static final String DOS_PUNTOS = " :";
	private static final String MAYOR_IGUAL = " >= ";
	private static final String MENOR_IGUAL = " <= ";
	private static final String PARENTESIS_DERECHO = " (";
	private static final String PARENTESIS_IZQUIERDO = ") ";
	private static final String WHERE = "WHERE ";
	private static final String AND = " AND  ";
	private static final String BETWEEN = " BETWEEN  ";
	private static final String HAVING = " HAVING  ";
	private static final String GROUP_BY = " GROUP BY  ";
	private static final String ORDER_BY = " ORDER BY ";
	private static final String COMA = " , ";
	private static final String LIMIT = " LIMIT ";
 
	private final String sqlInicial;
	
	private final RowMapper mapeoEntidad;
	
	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
	
	private final StringBuilder whereConsulta;
	
	private final Map<String, Object> parametrosResultantes;
	
	private final Map<String, Object> parametrosResultantesHaving;
	private final Map<String, String> parametrosResultantesGroupBy;
	private final Map<String, String> parametrosResultantesOrderBy;
	
	private final MapSqlParameterSource mapSqlParameterSource;
 
	public SqlBuilder(String sqlInicial, RowMapper mapeoEntidad, CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		
		this.sqlInicial = sqlInicial;
		this.mapeoEntidad = mapeoEntidad;
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
		this.whereConsulta = new StringBuilder();
		this.parametrosResultantes = new HashedMap<>();
		this.parametrosResultantesHaving = new HashedMap<>();
		this.parametrosResultantesGroupBy = new HashedMap<>();
		this.parametrosResultantesOrderBy = new HashedMap<>();
		this.mapSqlParameterSource = new MapSqlParameterSource();
	}
 
	public SqlBuilder(String sqlInicial, CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		
		this.sqlInicial = sqlInicial;
		this.mapeoEntidad = null;
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
		this.whereConsulta = new StringBuilder();
		this.parametrosResultantes = new HashedMap<>();
		this.parametrosResultantesHaving = new HashedMap<>();
		this.parametrosResultantesGroupBy = new HashedMap<>();
		this.parametrosResultantesOrderBy = new HashedMap<>();
		this.mapSqlParameterSource = new MapSqlParameterSource();
	}
 
	public SqlBuilder conIgual(Object valor, String campo) {
		String parametro = campo.replace(".","");

		if (valor != null && !valor.toString().isEmpty()) {
			
			if (this.parametrosResultantes.isEmpty()) {
				
				this.whereConsulta.append(WHERE).append(campo).append(IGUAL).append(DOS_PUNTOS).append(parametro);
			} else {
				this.whereConsulta.append(AND).append(campo).append(IGUAL).append(DOS_PUNTOS).append(parametro);
			}
			
			this.parametrosResultantes.put(campo, valor);
			this.mapSqlParameterSource.addValue(parametro, valor);
		}
		return this;
	}
 
	public SqlBuilder conIsNotNull(String campo) {
		
		if (this.parametrosResultantes.isEmpty()) {
			this.whereConsulta.append(WHERE).append(campo).append(IS_NOT_NULL);
		} else {
			this.whereConsulta.append(AND).append(campo).append(IS_NOT_NULL);
		}
		this.parametrosResultantes.put(campo, campo);
		return this;
	}
 
	public SqlBuilder conIsNull(String campo) {
		
		if (this.parametrosResultantes.isEmpty()) {
			this.whereConsulta.append(WHERE).append(campo).append(IS_NULL);
		} else {
			this.whereConsulta.append(AND).append(campo).append(IS_NULL);
		}
		
		this.parametrosResultantes.put(campo, campo);
		return this;
	}
 
	public <T> SqlBuilder conIn(List<T> valor, String campo) {
		
		String parametro = campo.replace(".","");
		
		if (valor != null && !valor.toString().isEmpty() && !valor.isEmpty()) {
			if (this.parametrosResultantes.isEmpty()) {
				this.whereConsulta.append(WHERE).append(campo).append(IN).append(PARENTESIS_DERECHO).append(DOS_PUNTOS)
						.append(parametro).append(PARENTESIS_IZQUIERDO);
			} else {
				this.whereConsulta.append(AND).append(campo).append(IN).append(PARENTESIS_DERECHO).append(DOS_PUNTOS)
						.append(parametro).append(PARENTESIS_IZQUIERDO);
			}
			
			this.parametrosResultantes.put(campo, valor);
			this.mapSqlParameterSource.addValue(parametro, valor);
		}
		return this;
	}
 
	public SqlBuilder conMayorMenorIgual(Object valor, String campo, Boolean mayor, String parametro) {
		
		if (valor != null && !valor.toString().isEmpty()) {
			if (this.parametrosResultantesHaving.isEmpty()) {
				this.whereConsulta.append(HAVING).append(campo).append(mayor ? MAYOR_IGUAL : MENOR_IGUAL).append(DOS_PUNTOS).append(parametro);
			} else {
				this.whereConsulta.append(AND).append(campo).append(mayor ? MAYOR_IGUAL : MENOR_IGUAL).append(DOS_PUNTOS).append(parametro);
			}
			this.parametrosResultantesHaving.put(campo, valor);
			this.mapSqlParameterSource.addValue(parametro, valor);
		}
		return this;
	}
 
	public SqlBuilder conHaving(Object valor, String campo) {
		
		String parametro = campo.replace(".","");
		
		if (valor != null && !valor.toString().isEmpty()) {
			if (this.parametrosResultantesHaving.isEmpty()) {
				this.whereConsulta.append(HAVING).append(campo).append(IGUAL).append(DOS_PUNTOS).append(parametro);
			} else {
				this.whereConsulta.append(AND).append(campo).append(IGUAL).append(DOS_PUNTOS).append(parametro);
			}
			
			this.parametrosResultantesHaving.put(campo, valor);
			this.mapSqlParameterSource.addValue(parametro, valor);
		}
		return this;
	}
 
	public SqlBuilder conBetweem(Object valorInicial, Object valorFinal, String campo) {
		
		String parametroInicial = campo.replace(".","");
		String parametroFinal = campo.replace(".","");
		
		
		if (valorInicial != null && !valorInicial.toString().isEmpty()  && valorFinal != null && !valorFinal.toString().isEmpty()) {
			
			if (this.parametrosResultantes.isEmpty()) {
				
				this.whereConsulta.append(WHERE).append(campo).append(BETWEEN).append(DOS_PUNTOS).append(parametroInicial).append(AND)
						.append(DOS_PUNTOS).append(parametroFinal);
				
			} else {
				this.whereConsulta.append(AND).append(campo).append(BETWEEN).append(DOS_PUNTOS).append(parametroInicial).append(AND)
						.append(DOS_PUNTOS).append(parametroFinal);
			}
			this.parametrosResultantes.put(campo, valorInicial);
			
			this.mapSqlParameterSource.addValue(parametroInicial, valorInicial);
			this.mapSqlParameterSource.addValue(parametroFinal, valorFinal);
			
		}
		return this;
	}
 
	public SqlBuilder conGroupBy(String campo) {
		
		if (campo != null && !campo.isEmpty()) {
			if (this.parametrosResultantesGroupBy.isEmpty()) {
				this.whereConsulta.append(GROUP_BY).append(campo);
			} else {
				this.whereConsulta.append(COMA).append(campo);
			}
			this.parametrosResultantesGroupBy.put(campo, campo);
		}
		return this;
	}
 
	public SqlBuilder conOrderBy(String campo, String ordenamiento) {
		
		if (campo != null && !campo.isEmpty()) {
			if (this.parametrosResultantesOrderBy.isEmpty()) {
				this.whereConsulta.append(ORDER_BY).append(campo).append(" ").append(ordenamiento);
			} else {
				this.whereConsulta.append(COMA).append(campo).append(" ").append(ordenamiento);
			}
			this.parametrosResultantesOrderBy.put(campo, campo);
		}
		return this;
	}
 
	public SqlBuilder conLimite(int paginaBusqueda, int registrosPorPaguina) {
		
		Integer limiteInferior = paginaBusqueda * registrosPorPaguina;
		this.whereConsulta.append(LIMIT).append(limiteInferior).append(",").append(registrosPorPaguina);
		return this;
	}
 
	public <T> List<T> buildQuery() {
		
		String consultaResultante = this.sqlInicial.replace(WHERE_REEMPLAZO, this.whereConsulta);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(consultaResultante, this.mapSqlParameterSource, this.mapeoEntidad);
	}
 
	public Integer buildQueryForObject() {
		
		String consultaResultante = this.sqlInicial.replace(WHERE_REEMPLAZO, this.whereConsulta);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(consultaResultante, mapSqlParameterSource, Integer.class);
	}
}