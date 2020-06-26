package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.afiliado.Afiliado;

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
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe un usuario con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);
    
    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);

}
