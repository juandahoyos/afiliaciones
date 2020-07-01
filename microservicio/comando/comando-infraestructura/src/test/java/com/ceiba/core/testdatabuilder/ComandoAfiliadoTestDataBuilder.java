package com.ceiba.core.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.core.comando.ComandoAfiliado;

public class ComandoAfiliadoTestDataBuilder {

	private int idAfiliado;
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
    
    public ComandoAfiliadoTestDataBuilder() {
        idAfiliado = 1;
        tipoDocumento = "CC";
        documento = "1234";
        nombre = "juan";
        apellido = "hoyos";
        sexo = "M";
        direccion = "calle 10";
        telefono = "54536";
        correo = "juan@hotmail.com";
        activo = true;
		fechaCreacion = LocalDateTime.now();
	}
    
    public ComandoAfiliadoTestDataBuilder conNombre(String nombre) {
    	this.nombre = nombre;
    	return this;
    }
    
    public ComandoAfiliado build() {
    	return new ComandoAfiliado(idAfiliado,tipoDocumento,documento,nombre,apellido,sexo,direccion,telefono,correo,activo,fechaCreacion);
    }
}
