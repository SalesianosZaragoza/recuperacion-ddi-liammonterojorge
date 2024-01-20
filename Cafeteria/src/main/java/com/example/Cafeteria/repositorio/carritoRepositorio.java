package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.awt.*;
import java.util.List;

public class carritoRepositorio {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<carrito> getTodosCarrito(){
        String sql = "SELECT * FROM carrito";
        RowMapper<carrito> rowMapper = new carritoRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public carrito getCarritoPorId(int idCarrito){
        String sql = "SELECT * FROM carrito WHERE id = ?";
        RowMapper<carrito> rowMapper = new BeanPropertyRowMapper<carrito>(carrito.class);
        carrito carrito = jdbcTemplate.queryForObject(sql, rowMapper, idCarrito);
        return carrito;
    }

    public void eliminarCarrito(carrito carrito){
        String sql = "DELETE FROM carrito WHERE id = ?";
        jdbcTemplate.update(sql, carrito.getId());
    }

public void actualizarCarrito(carrito carrito){
        String sql = "UPDATE carrito SET productos = ?, total = ? WHERE id = ?";
        jdbcTemplate.update(sql, carrito.getProductos(), carrito.getTotal(), carrito.getId());
    }

    public void insertarCarrito(carrito carrito){
        String sql = "INSERT INTO carrito (productos, total) VALUES (?, ?)";
        jdbcTemplate.update(sql, carrito.getProductos(), carrito.getTotal());
    }





}
