package com.ceiba.core.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.core.modelo.afiliado.Afiliado;

public class AfiliadoTestDataBuilder {

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
    
    public AfiliadoTestDataBuilder() {
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
    
    public AfiliadoTestDataBuilder conIdAfiliado(int idAfiliado) {
    	this.idAfiliado = idAfiliado;
    	return this;
    }
    
    public Afiliado build() {
        return new Afiliado(idAfiliado, tipoDocumento, documento, nombre, apellido, sexo, direccion, telefono, correo, activo);
    }

    public Afiliado buildCrear() {
        return new Afiliado(idAfiliado, tipoDocumento, documento, nombre, apellido, sexo, direccion, telefono, correo, activo);
    }
}
