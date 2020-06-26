package com.ceiba.core.controlador;


import java.util.List;

import com.ceiba.core.manejador.ManejadorListarAfiliados;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.core.modelo.DtoAfiliado;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/afiliados")
@Api(tags={"Controlador consulta afiliados"})
public class ConsultaControladorAfiliado {

	private final ManejadorListarAfiliados manejadorListarAfiliados;
    
    
	public ConsultaControladorAfiliado(ManejadorListarAfiliados manejadorListarAfiliados) {
		this.manejadorListarAfiliados = manejadorListarAfiliados;
	}

	@GetMapping
	@ApiOperation("Listar Afiliados")
	public List<DtoAfiliado> listar() {
		return this.manejadorListarAfiliados.ejecutar();
	}

}
