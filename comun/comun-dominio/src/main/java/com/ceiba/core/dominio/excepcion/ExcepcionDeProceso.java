package com.ceiba.core.dominio.excepcion;

public class ExcepcionDeProceso extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionDeProceso(String mensaje) {
        super(mensaje);
    }
}
