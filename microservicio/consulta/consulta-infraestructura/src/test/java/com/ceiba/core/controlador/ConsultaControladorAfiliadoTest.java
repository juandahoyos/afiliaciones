package com.ceiba.core.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.core.ApplicationMock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorAfiliado.class)
public class ConsultaControladorAfiliadoTest {

	@Autowired
	private MockMvc mocMvc;

	@Test
	public void listar() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/afiliados").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$[1].idAfiliado", CoreMatchers.is(2)))
				.andExpect(jsonPath("$[1].tipoDocumento", CoreMatchers.is("CC")))
				.andExpect(jsonPath("$[1].documento", CoreMatchers.is("1040030651")))
				.andExpect(jsonPath("$[1].nombre", CoreMatchers.is("Juan")))
				.andExpect(jsonPath("$[1].apellido", CoreMatchers.is("Hoyos")))
				.andExpect(jsonPath("$[1].sexo", CoreMatchers.is("M")))
				.andExpect(jsonPath("$[1].direccion", CoreMatchers.is("Calle 10")))
				.andExpect(jsonPath("$[1].telefono", CoreMatchers.is("5533887")))
				.andExpect(jsonPath("$[1].correo", CoreMatchers.is("juan@hotmail.com")))
				.andExpect(jsonPath("$[1].activo", CoreMatchers.is(true)))
				.andExpect(jsonPath("$[1].fechaCreacion", CoreMatchers.is("2020-03-08 00:00:00")));
	}
}
