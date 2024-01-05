package com.example.Cafeteria.repositorio;


import com.example.Cafeteria.modelos.producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class productoRepositorio {

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public static List<producto> getTodosProducto(){
        String query = "SELECT * FROM producto;";
        List<producto> listaProducto = jdbcTemplate.query(query, new productoRowMapper());
        return listaProducto;
    }

    public static producto getProductoPorId(int idProducto){
        String query = "SELECT * FROM producto WHERE id = ?";
        List<producto> listaProducto = jdbcTemplate.query(query, new productoRowMapper(), idProducto);
        return (listaProducto.isEmpty())? null: listaProducto.get(0);
    }

    public void eliminarProducto(producto producto){
        String query = "DELETE FROM producto WHERE id = ?";
        jdbcTemplate.update(query, producto.getId());
    }

    public void actualizarProducto(producto producto){
        String query = "UPDATE producto SET nombre = ?, precio = ? WHERE id = ?";
        jdbcTemplate.update(query,producto.getNombre(), producto.getPrecio(), producto.getId());
    }

    public static void insertarProducto(producto producto){
        String query = "INSERT INTO producto (nombre, precio) VALUES (?, ?);";
        jdbcTemplate.update(query, producto.getNombre(), producto.getPrecio());
    }


}


