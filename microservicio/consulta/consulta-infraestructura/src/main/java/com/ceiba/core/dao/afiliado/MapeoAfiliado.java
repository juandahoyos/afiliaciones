package com.ceiba.core.dao.afiliado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoAfiliado;

public class MapeoAfiliado implements RowMapper<DtoAfiliado>,MapperResult {

    @Override
    public DtoAfiliado mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        
    	Integer idAfiliado = resultSet.getInt("IdAfiliado");
        String documento = resultSet.getString("Documento");
        String tipoDocumento = resultSet.getString("TipoDocumento");
        String nombre = resultSet.getString("Nombre");
        String apellido = resultSet.getString("Apellido");
        String sexo = resultSet.getString("Sexo");
        String direccion = resultSet.getString("Direccion");
        String telefono = resultSet.getString("Telefono");
        String correo = resultSet.getString("Correo");
        boolean activo = resultSet.getBoolean("Activo");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "FechaCreacion");

        return new DtoAfiliado(idAfiliado,tipoDocumento,documento,nombre,apellido,sexo,direccion,telefono,correo,activo,fechaCreacion);
    }

}
