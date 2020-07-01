package com.ceiba.core.servicio.afiliado;

import com.ceiba.core.dominio.excepcion.ExcepcionDeProceso;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.repositorio.RepositorioAfiliado;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicioCrearAfiliado {

	private static final Logger LOGGER = Logger.getLogger(ServicioCrearAfiliado.class.getName());
	private static final String MENSAJE_CEDULA_YA_EXISTE = "No se puede crear el afiliado, porque la cédula ya existe.";
	private static final String EL_AFILIADO_YA_EXISTE_EN_EL_SISTEMA = "El afiliado ya existe en el sistema";
    
	private final RepositorioAfiliado repositorioAfiliado;

    public ServicioCrearAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public String ejecutar(Afiliado afiliado) {
		validarExistenciaPrevia(afiliado.getDocumento());
		try {
			return repositorioAfiliado.crear(afiliado).toString();
		} catch(RuntimeException e) {
			LOGGER.log(Level.INFO, "an exception was thrown", e);
			throw new ExcepcionDeProceso(MENSAJE_CEDULA_YA_EXISTE);
		}
	}

	private void validarExistenciaPrevia(String documento) {
		boolean existe = this.repositorioAfiliado.existe(documento);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_AFILIADO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

}
