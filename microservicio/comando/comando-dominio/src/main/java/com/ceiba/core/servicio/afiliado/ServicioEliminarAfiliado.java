package com.ceiba.core.servicio.afiliado;

import com.ceiba.core.repositorio.RepositorioAfiliado;

public class ServicioEliminarAfiliado {

    private final RepositorioAfiliado repositorioAfiliado;

    public ServicioEliminarAfiliado(RepositorioAfiliado repositorioAfiliado) {
        this.repositorioAfiliado = repositorioAfiliado;
    }

    public void ejecutar(Long id) {
        this.repositorioAfiliado.eliminar(id);
    }
}
