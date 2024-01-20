package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.carrito;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class carritoRowMapper implements RowMapper<carrito> {

    @Override
    public carrito mapRow(ResultSet rs, int rowNum) throws SQLException {
        carrito carrito = new carrito();
        carrito.setId(rs.getInt("id"));

        carrito.setTotal(rs.getDouble("total"));

        return carrito;
    }


}
