package com.ceiba.core.servicio.afiliado;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.afiliado.Afiliado;
import com.ceiba.core.repositorio.RepositorioAfiliado;

public class ServicioActualizarAfiliado {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    
	private final RepositorioAfiliado repositorioAfiliado;

    public ServicioActualizarAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public void ejecutar(Afiliado afiliado) {
    	validarExistenciaPrevia(afiliado);
        this.repositorioAfiliado.actualizar(afiliado);
    }

	private void validarExistenciaPrevia(Afiliado afiliado) {
		boolean existe = this.repositorioAfiliado.existeExcluyendoId(afiliado.getId(), afiliado.getNombre());
    	if(existe) {
    		throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
    	}
	}
}
