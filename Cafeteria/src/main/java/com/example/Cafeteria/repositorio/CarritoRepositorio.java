package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.Carrito;
import com.example.Cafeteria.modelos.Producto;
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
        String sql = "UPDATE carrito SET total = ? WHERE id = ?";
        jdbcTemplate.update(sql, carrito.getTotal(), carrito.getId());
    }

    public void agregarProductoAlCarrito(Carrito carrito, Producto producto){
        String sql = "INSERT INTO CARRITO_PRODUCTO (id_carrito, id_producto) VALUES (?, ?)";
        jdbcTemplate.update(sql, carrito.getId(), producto.getId());
    }

    public List<Producto> getProductosDelCarrito(Carrito carrito){
        String sql = "SELECT * FROM PRODUCTO WHERE id IN (SELECT id_producto FROM CARRITO_PRODUCTO WHERE id_carrito = ?)";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Producto.class), carrito.getId());
    }
}

