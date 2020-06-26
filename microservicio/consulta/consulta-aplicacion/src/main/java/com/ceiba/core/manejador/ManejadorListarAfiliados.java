package com.ceiba.core.manejador;

import java.util.List;

import com.ceiba.core.dao.DaoAfiliado;
import org.springframework.stereotype.Component;
import com.ceiba.core.dao.DaoUsuarioFiltro;
import com.ceiba.core.modelo.DtoFiltroUsuario;
import com.ceiba.core.modelo.DtoAfiliado;

@Component
public class ManejadorListarAfiliados {

    private final DaoAfiliado daoAfiliado;

    public ManejadorListarAfiliados(DaoAfiliado daoAfiliado){
        this.daoAfiliado=daoAfiliado;
    }

    public List<DtoAfiliado> ejecutar(){
       return this.daoAfiliado.listar();
    }
    
}
