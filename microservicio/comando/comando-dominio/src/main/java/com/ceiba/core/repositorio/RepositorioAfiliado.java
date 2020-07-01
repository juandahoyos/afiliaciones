package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.afiliado.Afiliado;

import java.util.List;

public interface RepositorioAfiliado {
	/**
	 * Permite crear un usuario
	 * @param afiliado
	 * @return el id generado
	 */
    Long crear(Afiliado afiliado);
    
    /**
	 * Permite actualizar un usuario
	 * @param afiliado
	 */
    void actualizar(Afiliado afiliado);
    
    /**
     * Permite eliminar un usuario
     * @param idAfiliado
     */
    void eliminar(Long idAfiliado);

	/**
	 * Permite validar si existe un afiliado con el número de documento
	 * @param documento
	 * @return si existe o no
	 */
	boolean existe(String documento);

    /**
     * Metodo para validar si un afiliafo existe o no
     * @param idAfiliado
     * @return lista con el id del afiliado
     */
    List<Integer> existeAfiliado(int idAfiliado);
}
