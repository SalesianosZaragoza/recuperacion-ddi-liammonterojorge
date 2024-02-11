package com.example.Cafeteria.controladores;

import com.example.Cafeteria.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @RequestMapping("/listarUsuario")
    public String listaUsuario(){
        return "listaUsuario";
    }

    @RequestMapping("/formInsertarUsuario")
    public String formInsertarUsuario(){
        return "formUsuario";
    }

    @RequestMapping("/insertarUsuario")
    public String insertarUsuario(){
        return "listaUsuario";
    }
}
