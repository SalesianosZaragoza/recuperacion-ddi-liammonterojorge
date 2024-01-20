package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.Carrito;
import com.example.Cafeteria.repositorio.CarritoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CarritoControlador {

    @Autowired
    CarritoRepositorio carritoRepositorio;

    @RequestMapping("/listarCarrito")
    public String listaCarrito(Model model) {
        List<Carrito> listaCarrito = carritoRepositorio.getTodosCarrito();
        model.addAttribute("listaCarrito", listaCarrito);
        return "listaCarrito";
    }

    @RequestMapping("/formInsertarCarrito")
    public String formInsertarCarrito(Model model) {
        Carrito carrito = new Carrito();
        model.addAttribute("nuevoCarrito", carrito);
        return "formCarrito";
    }

    @RequestMapping("/insertarCarrito")
    public String insertarCarrito(Carrito car, Model model) {
        carritoRepositorio.insertarCarrito(car);
        return "redirect:/listaCarrito";
    }

    @RequestMapping("/formModificarCarrito/{id}")
    public String formModificarCarrito(Model model, @PathVariable String id) {
        Carrito carrito = carritoRepositorio.getCarritoPorId(Integer.parseInt(id));
        model.addAttribute("carrito", carrito);
        return "formModificarCarrito";
    }

    @RequestMapping("/eliminarCarrito/{id}")
    public String eliminarCarrito(Model model, @PathVariable String id) {
        Carrito carrito = carritoRepositorio.getCarritoPorId(Integer.parseInt(id));
        carritoRepositorio.eliminarCarrito(carrito);
        return "redirect:/listaCarrito";
    }

    @RequestMapping("/actualizarCarrito")
    public String actualizarCarrito(Carrito carrito, Model model) {
        carritoRepositorio.actualizarCarrito(carrito);
        return "redirect:/listaCarrito";
    }
}

