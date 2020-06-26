package com.ceiba.core.servicio.afiliado;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.repositorio.RepositorioAfiliado;
import com.ceiba.core.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioCrearAfiliadoTest {

	@Test
    public void validarClaveLongitudMenor4Test() {
        // arrange
    	UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }
	
	@Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
    	Afiliado afiliado = new UsuarioTestDataBuilder().build();
    	RepositorioAfiliado repositorioAfiliado = Mockito.mock(RepositorioAfiliado.class);
    	Mockito.when(repositorioAfiliado.existe(Mockito.anyString())).thenReturn(true);
    	ServicioCrearAfiliado servicioCrearAfiliado = new ServicioCrearAfiliado(repositorioAfiliado);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAfiliado.ejecutar(afiliado), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
