package com.example.Cafeteria.repositorio;

import com.example.Cafeteria.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositorio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Usuario> getTodosUsuario(){
        String query = "SELECT * FROM usuario;";
        List<Usuario> listaUsuario = jdbcTemplate.query(query, new UsuarioRowMapper());
        return listaUsuario;
    }

    public Usuario findByUsernameAndPassword(String username, String password) {
        String query = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        List<Usuario> listaUsuario = jdbcTemplate.query(query, new UsuarioRowMapper(), username, password);
        return (listaUsuario.isEmpty())? null: listaUsuario.get(0);
    }








}
