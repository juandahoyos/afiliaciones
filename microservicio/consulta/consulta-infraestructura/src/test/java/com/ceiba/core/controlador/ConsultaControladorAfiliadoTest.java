package com.ceiba.core.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	private static final String NOMBRE = "sergio";
	private static final String FECHA_CREACION = "2019-09-11";

	@Test
	public void listar() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/usuarios").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(4)))
				.andExpect(jsonPath("$[0].nombre", is("test")))
				.andExpect(jsonPath("$[1].nombre", is("pedro")))
				.andExpect(jsonPath("$[2].nombre", is("sergio")))
				.andExpect(jsonPath("$[3].nombre", is("mary")));
	}

	@Test
	public void filtrarPorFechaMayorIgual() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/usuarios?fechaCreacion=" + FECHA_CREACION).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].fechaCreacion", is("2019-09-11 00:00:00")))
				.andExpect(jsonPath("$[1].fechaCreacion", is("2019-09-14 00:00:00")));

	}

	@Test
	public void filtrarPorNombre() throws Exception {
		// arrange

		// act - assert
		mocMvc.perform(get("/usuarios?nombre=" + NOMBRE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].nombre", is("sergio")));

	}

	

}
