package com.ceiba.core.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAfiliado {

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
}
