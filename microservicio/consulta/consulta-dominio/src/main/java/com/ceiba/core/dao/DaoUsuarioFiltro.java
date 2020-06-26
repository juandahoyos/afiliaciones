package com.ceiba.core.dao;

import java.util.List;

import com.ceiba.core.modelo.DtoFiltroUsuario;
import com.ceiba.core.modelo.DtoAfiliado;

public interface DaoUsuarioFiltro {

	public List<DtoAfiliado> filtroUsuario(DtoFiltroUsuario filtro);
	
}
