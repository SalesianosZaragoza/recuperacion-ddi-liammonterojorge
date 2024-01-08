package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.producto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class productoRowMapper implements RowMapper<producto> {

    @Override
    public producto mapRow(ResultSet rs, int rowNum) throws SQLException {
        producto producto = new producto();
        producto.setId(rs.getInt("id"));
        producto.setNombre(rs.getString("nombre"));
        producto.setPrecio(rs.getDouble("precio"));
        return producto;
    }
}
