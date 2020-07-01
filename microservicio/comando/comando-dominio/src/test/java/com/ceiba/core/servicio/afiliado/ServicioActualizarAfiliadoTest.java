package com.ceiba.core.servicio.afiliado;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionNoExisteRegistro;
import com.ceiba.core.repositorio.RepositorioAfiliado;
import com.ceiba.core.servicio.testdatabuilder.AfiliadoTestDataBuilder;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class ServicioActualizarAfiliadoTest {

	private static final String NO_EXISTE_AFILIADO= "El afiliado que está intentando actualizar no existe";

	private ServicioActualizarAfiliado servicioActualizarAfiliado;
	private RepositorioAfiliado repositorioAfiliado;

	@Before
	public void setUp() {
		repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
		servicioActualizarAfiliado = new ServicioActualizarAfiliado(repositorioAfiliado);
	}
	
	@Test
	public void actualizarEmpleadoTest() {
		Mockito.when(repositorioAfiliado.existeAfiliado(Mockito.anyInt())).thenReturn(Collections.singletonList(1));
		int idAfiliadoActualizado = servicioActualizarAfiliado.ejecutar(new AfiliadoTestDataBuilder().build());
		assertEquals(1, idAfiliadoActualizado);
	}

	@Test
	public void validarAfiliadoExistenciaPreviaTest() {
		Mockito.when(repositorioAfiliado.existeAfiliado(Mockito.anyInt())).thenReturn(new ArrayList<Integer>());
		BasePrueba.assertThrows(() -> servicioActualizarAfiliado.ejecutar(new AfiliadoTestDataBuilder().build()),
				ExcepcionNoExisteRegistro.class, NO_EXISTE_AFILIADO);
	}
}
