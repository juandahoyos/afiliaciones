package com.ceiba.core.modelo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoAfiliado {

	private int id;
	private String tipoDocumento;
	private String documento;
    private String nombre;
    private String apellido;
    private String sexo;
    private String direccion;
    private String telefono;
    private String correo;
    private boolean activo;
    private LocalDateTime fechaCreacion;
}
