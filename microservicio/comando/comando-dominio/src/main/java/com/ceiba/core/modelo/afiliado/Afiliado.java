package com.ceiba.core.modelo.afiliado;

import static com.ceiba.core.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.core.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

public class Afiliado {

	private static final String SE_DEBE_SELECCIONAR_EL_TIPO_DE_DOCUMENTO = "Se debe seleccionar el tipo de documento";
	private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO = "Se debe ingresar el número de documento";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AFILIADO= "Se debe ingresar el nombre del afiliado";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_AFILIADO= "Se debe ingresar el apellido del afiliado";
    private static final String SE_DEBE_SELECCIONAR_EL_SEXO= "Se debe seleccionar el sexo del afiliado";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION= "Se debe ingresar la direccion del afiliado";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_TELEFONO= "Se debe ingresar el número de telefono del afiliado ";
    private static final String SE_DEBE_INGRESAR_EL_CORREO= "Se debe ingresar el correo del afiliado";
    private static final String SE_DEBE_SELECCIONAR_UN_ESTADO= "Se debe seleccionar el estado del afiliado";
    
	private Long id;
	private String tipoDocumento;
	private String documento;
    private String nombre;
	private String apellido;
	private String sexo;
	private String direccion;
	private String telefono;
	private String correo;
    private boolean activo;

    public Afiliado(Long id, String tipoDocumento, String documento, String nombre, String apellido, String sexo, String direccion,
                    String telefono, String correo, boolean activo) {
        validarObligatorio(tipoDocumento, SE_DEBE_SELECCIONAR_EL_TIPO_DE_DOCUMENTO);
        validarObligatorio(documento, SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_AFILIADO);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_EL_APELLIDO_DEL_AFILIADO);
        validarObligatorio(sexo, SE_DEBE_SELECCIONAR_EL_SEXO);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_NUMERO_DE_TELEFONO);
        validarObligatorio(correo, SE_DEBE_INGRESAR_EL_CORREO);
        validarObligatorio(activo, SE_DEBE_SELECCIONAR_UN_ESTADO);


        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isActivo() {
        return activo;
    }
}
