package com.example.Cafeteria.repositorio;


import com.example.Cafeteria.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepositorio {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Producto> getTodosProducto(){
        String query = "SELECT * FROM producto;";
        List<Producto> listaProducto = jdbcTemplate.query(query, new ProductoRowMapper());
        return listaProducto;
    }

    public Producto getProductoPorId(int idProducto){
        String query = "SELECT * FROM producto WHERE id = ?";
        List<Producto> listaProducto = jdbcTemplate.query(query, new ProductoRowMapper(), idProducto);
        return (listaProducto.isEmpty())? null: listaProducto.get(0);
    }

    public void eliminarProducto(Producto producto){
        String query = "DELETE FROM producto WHERE id = ?";
        jdbcTemplate.update(query, producto.getId());
    }

    public void actualizarProducto(Producto producto){
        String query = "UPDATE producto SET nombre = ?, precio = ?, imagen = ?, WHERE id = ?";
        jdbcTemplate.update(query,producto.getNombre(), producto.getPrecio(), producto.getId(), producto.getImagen());
    }

    public void insertarProducto(Producto producto){
        String query = "INSERT INTO producto (nombre, precio, imagen) VALUES (?, ?, ?);";
        jdbcTemplate.update(query, producto.getNombre(), producto.getPrecio(), producto.getImagen());
    }


}


