package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.producto;
import com.example.Cafeteria.repositorio.productoRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class productoControlador {


    @RequestMapping("/listaProducto")
    public String listaProducto(Model model){
        List<producto> listaProducto = productoRepositorio.getTodosProducto();
        model.addAttribute("listaProducto", listaProducto);
        return "listaProducto";
    }

    @RequestMapping("/formInsertarProducto")
    public String formInsertarProducto(Model model){
        producto producto = new producto();
        model.addAttribute("nuevoProducto", producto);
        return "formProducto";
    }

    @RequestMapping("/insertarProducto")
    public String insertarProducto(producto producto, Model model){
        productoRepositorio.insertarProducto(producto);
        return listaProducto(model);
    }

    @RequestMapping("/formModificarProducto/{id}")
    public String formModificarProducto(Model model, @PathVariable String id){
        producto producto = productoRepositorio.getProductoPorId(Integer.parseInt(id));
        model.addAttribute("producto", producto);
        return "formModificarProducto";
    }

}
