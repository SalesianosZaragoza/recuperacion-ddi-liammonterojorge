package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.Producto;
import com.example.Cafeteria.modelos.Usuario;
import com.example.Cafeteria.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String insertarUsuario(Usuario user, Model model){
        usuarioRepositorio.insertarUsuario(user);
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
            return "formInicioSesion"; // Redirecciona de nuevo a la página de inicio de sesión
        }
    }

    @RequestMapping("/InicioSesion")
    public String iniciarUsuarioForm(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "formInicioSesion";
    }
     @RequestMapping("/loginUsuario")
    public String formLoginUsuario(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("nuevoUsuario", usuario);
        return "login";
    }
    @PostMapping("/comprobarUsuario")
    public String comprobarUsuario(@RequestParam("nombreUsuario") String nombreUsuario,
                                    @RequestParam("contraseña") String contraseña,
                                    Model model) {
        // Aquí iría tu lógica para comprobar el usuario y la contraseña en la base de datos
        Usuario usuarioEncontrado = usuarioRepositorio.findByUsernameAndPassword(nombreUsuario, contraseña);
        // Por ejemplo, podrías verificar si las credenciales coinciden con las de un usuario en la base de datos
        if (usuarioEncontrado != null && usuarioEncontrado.getContrasena().equals(contraseña) && usuarioEncontrado.getNombre().equals(nombreUsuario)) {
            // Si las credenciales son válidas, podrías redirigir a una página de éxito
            return "redirect:/listarProducto";
        } else {
            // Si las credenciales no son válidas, podrías mostrar un mensaje de error en la misma página
            model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
            return "login";
        }
    }
    @RequestMapping("/registroUsuario")
    public String formRegistrarUsuario(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("nuevoUsuario", usuario);
        return "formUsuario";
    }

    
}
