package com.ceiba.core.servicio.afiliado;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.repositorio.RepositorioAfiliado;

public class ServicioCrearAfiliado {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    
	private final RepositorioAfiliado repositorioAfiliado;

    public ServicioCrearAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public Long ejecutar(Afiliado afiliado) {
    	validarExistenciaPrevia(afiliado);
        return this.repositorioAfiliado.crear(afiliado);
    }

	private void validarExistenciaPrevia(Afiliado afiliado) {
		boolean existe = this.repositorioAfiliado.existe(afiliado.getNombre());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
