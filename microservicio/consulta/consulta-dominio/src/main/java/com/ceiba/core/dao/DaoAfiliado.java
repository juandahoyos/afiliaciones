package com.ceiba.core.dao;

import java.util.List;

import com.ceiba.core.modelo.DtoAfiliado;

public interface DaoAfiliado {

	/**
	 * Permite listar afiliados
	 * @return los afiliados
	 */
	List<DtoAfiliado> listar();

}