package com.ceiba.core.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.core.repositorio.RepositorioAfiliado;
import com.ceiba.core.servicio.afiliado.ServicioActualizarAfiliado;
import com.ceiba.core.servicio.afiliado.ServicioCrearAfiliado;
import com.ceiba.core.servicio.afiliado.ServicioEliminarAfiliado;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearAfiliado servicioCrearAfiliado(RepositorioAfiliado repositorioAfiliado) {
		return new ServicioCrearAfiliado(repositorioAfiliado);
	}

	@Bean
	public ServicioEliminarAfiliado servicioEliminarAfiliado(RepositorioAfiliado repositorioAfiliado) {
		return new ServicioEliminarAfiliado(repositorioAfiliado);
	}
	
	@Bean
	public ServicioActualizarAfiliado servicioActualizarAfiliado(RepositorioAfiliado repositorioAfiliado) {
		return new ServicioActualizarAfiliado(repositorioAfiliado);
	}

}
