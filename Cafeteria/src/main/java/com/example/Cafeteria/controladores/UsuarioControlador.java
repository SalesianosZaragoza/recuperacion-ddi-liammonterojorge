package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.*;
import com.example.Cafeteria.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.List;

@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @RequestMapping("/listarUsuario")
    public String listaUsuario(Model model){
        List<Usuario> lisatUser = usuarioRepositorio.getTodosUsuario();
        model.addAttribute("listaUsuario", lisatUser);
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

    @PostMapping("/InicioSesion")
    public String login(@RequestParam String usuario, @RequestParam String nombre, @RequestParam String contrasena, Model model) {
        // Consulta la base de datos para verificar las credenciales
        Usuario user = usuarioRepositorio.findByUsernameAndPassword(nombre, contrasena);

        if (user != null) {
            // Usuario y contraseña válidos, redirecciona a la página de inicio correspondiente
            return "listaProductoPrivate";
        } else {
            // Usuario o contraseña incorrectos, muestra un mensaje de error
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "InicioSesion"; // Redirecciona de nuevo a la página de inicio de sesión
        }
    }

    @RequestMapping("/InicioSesion")
    public String iniciarUsuarioForm(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "InicioSesion";
    }

    
}
