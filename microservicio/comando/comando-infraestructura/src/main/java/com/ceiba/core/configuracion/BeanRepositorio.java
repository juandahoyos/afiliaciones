package com.ceiba.core.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.repositorio.RepositorioAfiliado;
import com.ceiba.core.repositorio.RepositorioAfiliadoMysql;

@Configuration
public class BeanRepositorio {

	@Bean
	public RepositorioAfiliado repositorioAfiliado(CustomNamedParameterJdbcTemplate repositorioGenerico) {
		return new RepositorioAfiliadoMysql(repositorioGenerico);
	}

}
