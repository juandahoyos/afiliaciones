package com.ceiba.core.manejador;

import com.ceiba.core.modelo.afiliado.Afiliado;
import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoAfiliado;
import com.ceiba.core.fabrica.FabricaAfiliado;
import com.ceiba.core.servicio.afiliado.ServicioActualizarAfiliado;

@Component
public class ManejadorActualizarAfiliado implements ManejadorComando<ComandoAfiliado> {

	private final FabricaAfiliado fabricaAfiliado;
	private final ServicioActualizarAfiliado servicioActualizarAfiliado;

	public ManejadorActualizarAfiliado(FabricaAfiliado fabricaAfiliado, ServicioActualizarAfiliado servicioActualizarAfiliado) {
		this.fabricaAfiliado = fabricaAfiliado;
		this.servicioActualizarAfiliado = servicioActualizarAfiliado;
	}

	public void ejecutar(ComandoAfiliado comandoAfiliado) {
		Afiliado afiliado = this.fabricaAfiliado.actualizar(comandoAfiliado);
		this.servicioActualizarAfiliado.ejecutar(afiliado);
	}
}
