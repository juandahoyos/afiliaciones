package com.ceiba.core.dominio.excepcion;

public class ExcepcionNoExisteRegistro extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionNoExisteRegistro(String mensaje) {
        super(mensaje);
    }
}
