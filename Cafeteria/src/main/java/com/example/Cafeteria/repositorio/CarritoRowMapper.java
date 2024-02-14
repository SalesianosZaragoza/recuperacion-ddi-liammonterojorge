package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.Carrito;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarritoRowMapper implements RowMapper<Carrito> {

    @Override
    public Carrito mapRow(ResultSet rs, int rowNum) throws SQLException {
        Carrito carrito = new Carrito();

        carrito.setId(rs.getInt("id"));
        carrito.setTotal(rs.getDouble("total"));

        return carrito;
    }


}
