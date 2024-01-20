package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarritoRepositorio {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Carrito> getTodosCarrito(){
        String sql = "SELECT * FROM carrito";
        RowMapper<Carrito> rowMapper = new CarritoRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Carrito getCarritoPorId(int idCarrito){
        String sql = "SELECT * FROM carrito WHERE id = ?";
        RowMapper<Carrito> rowMapper = new BeanPropertyRowMapper<Carrito>(Carrito.class);
        Carrito carrito = jdbcTemplate.queryForObject(sql, rowMapper, idCarrito);
        return carrito;
    }

    public void eliminarCarrito(Carrito carrito){
        String sql = "DELETE FROM carrito WHERE id = ?";
        jdbcTemplate.update(sql, carrito.getId());
    }

public void actualizarCarrito(Carrito carrito){
        String sql = "UPDATE carrito SET productos = ?, total = ? WHERE id = ?";
        jdbcTemplate.update(sql, carrito.getProductos(), carrito.getTotal(), carrito.getId());
    }

    public void insertarCarrito(Carrito carrito){
        String sql = "INSERT INTO carrito (productos, total) VALUES (?, ?)";
        jdbcTemplate.update(sql, carrito.getProductos(), carrito.getTotal());
    }





}
