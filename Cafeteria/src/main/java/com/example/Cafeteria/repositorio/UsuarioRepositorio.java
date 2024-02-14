package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositorio {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Usuario> getTodosUsuario(){
        String query = "SELECT * FROM usuario;";
        List<Usuario> listaUsuario = jdbcTemplate.query(query, new UsuarioRowMapper());
        return listaUsuario;
    }

    public Usuario findByUsernameAndPassword(String nombre, String contrasena) {
        String query = "SELECT * FROM usuario WHERE nombre = ? AND contrasena = ?";
        List<Usuario> listaUsuario = jdbcTemplate.query(query, new UsuarioRowMapper(), nombre, contrasena);
        return (listaUsuario.isEmpty())? null: listaUsuario.get(0);
    }
}
