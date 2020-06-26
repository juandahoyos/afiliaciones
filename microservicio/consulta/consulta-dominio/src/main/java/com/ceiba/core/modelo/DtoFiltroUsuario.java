package com.ceiba.core.modelo;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoFiltroUsuario {
     
	 private String nombre;
     private  LocalDate fechaCreacion;
	
}
