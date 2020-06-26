package com.ceiba.core.servicio.afiliado;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.repositorio.RepositorioAfiliado;
import com.ceiba.core.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioActualizarAfiliadoTest {
	
	@Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
    	Afiliado afiliado = new UsuarioTestDataBuilder().conId(1L).build();
    	RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
    	Mockito.when(repositorioAfiliado.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
    	ServicioActualizarAfiliado servicioActualizarAfiliado = new ServicioActualizarAfiliado(repositorioAfiliado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAfiliado.ejecutar(afiliado), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
