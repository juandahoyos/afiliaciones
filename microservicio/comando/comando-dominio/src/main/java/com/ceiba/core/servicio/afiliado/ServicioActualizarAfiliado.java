package com.ceiba.core.servicio.afiliado;

import com.ceiba.core.dominio.excepcion.ExcepcionNoExisteRegistro;
import com.ceiba.core.dominio.excepcion.ExcepcionDeProceso;
import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.repositorio.RepositorioAfiliado;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioActualizarAfiliado {

	private static final Logger LOGGER = Logger.getLogger(ServicioActualizarAfiliado.class.getName());
	private static final String NO_EXISTE_AFILIADO = "El afiliado que está intentando actualizar no existe";
	private static final String MENSAJE_CEDULA_YA_EXISTE = "No se puede crear el empleado, porque la cédula ya existe.";
    
	private final RepositorioAfiliado repositorioAfiliado;

    public ServicioActualizarAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public int ejecutar(Afiliado afiliado) {
    	validarExistenciaPrevia(afiliado.getIdAfiliado());
		try {
			repositorioAfiliado.actualizar(afiliado);
		} catch (RuntimeException e) {
			LOGGER.log(Level.INFO, "an exception was thrown", e);
			throw new ExcepcionDeProceso(MENSAJE_CEDULA_YA_EXISTE);
		}
		return afiliado.getIdAfiliado();
    }

	private void validarExistenciaPrevia(int idAfiliado) {
    	if(repositorioAfiliado.existeAfiliado(idAfiliado).isEmpty()) {
    		throw new ExcepcionNoExisteRegistro(NO_EXISTE_AFILIADO);
    	}
	}
}
