package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoAfiliado;
import com.ceiba.core.fabrica.FabricaAfiliado;
import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.servicio.afiliado.ServicioCrearAfiliado;

@Component
public class ManejadorCrearAfiliado implements ManejadorComandoRespuesta<ComandoAfiliado, ComandoRespuesta<Long>> {

	private final FabricaAfiliado fabricaAfiliado;
	private final ServicioCrearAfiliado servicioCrearAfiliado;

	public ManejadorCrearAfiliado(FabricaAfiliado fabricaAfiliado, ServicioCrearAfiliado servicioCrearAfiliado) {
		this.fabricaAfiliado = fabricaAfiliado;
		this.servicioCrearAfiliado = servicioCrearAfiliado;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoAfiliado comandoAfiliado) {
		Afiliado afiliado = this.fabricaAfiliado.crear(comandoAfiliado);
		return new ComandoRespuesta<>(this.servicioCrearAfiliado.ejecutar(afiliado));
	}
}
