package com.ceiba.core.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.comando.ComandoAfiliado;
import com.ceiba.core.manejador.ManejadorActualizarAfiliado;
import com.ceiba.core.manejador.ManejadorCrearAfiliado;
import com.ceiba.core.manejador.ManejadorEliminarAfiliado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/afiliados")
@Api(tags = { "Controlador comando afiliado"})
public class ComandoControladorAfiliado {

	private final ManejadorCrearAfiliado manejadorCrearAfiliado;
	private final ManejadorEliminarAfiliado manejadorEliminarAfiliado;
	private final ManejadorActualizarAfiliado manejadorActualizarAfiliado;

	@Autowired
	public ComandoControladorAfiliado(ManejadorCrearAfiliado manejadorCrearAfiliado,
									  ManejadorEliminarAfiliado manejadorEliminarAfiliado, ManejadorActualizarAfiliado manejadorActualizarAfiliado) {
		this.manejadorCrearAfiliado = manejadorCrearAfiliado;
		this.manejadorEliminarAfiliado = manejadorEliminarAfiliado;
		this.manejadorActualizarAfiliado = manejadorActualizarAfiliado;
	}

	@PostMapping
	@ApiOperation("Crear Afiliado")
	public ComandoRespuesta<String> crear(@RequestBody ComandoAfiliado comandoAfiliado) {
		return manejadorCrearAfiliado.ejecutar(comandoAfiliado);
	}

	@DeleteMapping(value="/{idAfiliado}")
	@ApiOperation("Eliminar Afiliado")
	public void eliminar(@PathVariable Long idAfiliado) {
		manejadorEliminarAfiliado.ejecutar(idAfiliado);
	}
	
	@PutMapping(value="/{idAfiliado}")
	@ApiOperation("Actualizar Afiliado")
	public void actualizar(@RequestBody ComandoAfiliado comandoAfiliado, @PathVariable Integer idAfiliado) {
		comandoAfiliado.setIdAfiliado(idAfiliado);
		manejadorActualizarAfiliado.ejecutar(comandoAfiliado);
	}
}
