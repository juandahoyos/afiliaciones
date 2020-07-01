package com.ceiba.core.servicio.afiliado;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.repositorio.RepositorioAfiliado;
import com.ceiba.core.servicio.testdatabuilder.AfiliadoTestDataBuilder;

import static org.junit.Assert.assertEquals;

public class ServicioCrearAfiliadoTest {

	private ServicioCrearAfiliado servicioCrearAfiliado;
	private RepositorioAfiliado repositorioAfiliado;

	@Before
	public void setUp() {
		repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
		servicioCrearAfiliado = new ServicioCrearAfiliado(repositorioAfiliado);
	}

	@Test
	public void crearAfiliadoTest() {
		Mockito.when(repositorioAfiliado.crear(Mockito.any(Afiliado.class))).thenReturn(1L);
		int idCreado = Math.toIntExact(servicioCrearAfiliado.ejecutar(new AfiliadoTestDataBuilder().buildCrear()));
		assertEquals(1, idCreado);
	}
}
