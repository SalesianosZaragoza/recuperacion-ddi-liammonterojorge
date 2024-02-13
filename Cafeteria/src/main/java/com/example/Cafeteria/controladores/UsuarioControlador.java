package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.Producto;
import com.example.Cafeteria.modelos.Usuario;
import com.example.Cafeteria.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @RequestMapping("/listarUsuario")
    public String listaUsuario(Model model){
        List<Usuario> listaUsuario = UsuarioRepositorio.getTodosUsuario();
        model.addAttribute("listaUsuario", listaUsuario);
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
