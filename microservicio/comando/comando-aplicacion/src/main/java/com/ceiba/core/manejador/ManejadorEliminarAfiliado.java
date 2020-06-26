package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.servicio.afiliado.ServicioEliminarAfiliado;

@Component
public class ManejadorEliminarAfiliado implements ManejadorComando<Long> {

	private final ServicioEliminarAfiliado servicioEliminarAfiliado;

	public ManejadorEliminarAfiliado(ServicioEliminarAfiliado servicioEliminarAfiliado) {
		this.servicioEliminarAfiliado = servicioEliminarAfiliado;
	}

	public void ejecutar(Long idAfiliado) {
		this.servicioEliminarAfiliado.ejecutar(idAfiliado);

	}
}
