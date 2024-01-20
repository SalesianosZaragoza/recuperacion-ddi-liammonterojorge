package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.producto;
import com.example.Cafeteria.repositorio.productoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class productoControlador {


    @Autowired
    private productoRepositorio productoRepositorio;

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
    public String insertarProducto(producto prod, Model model){
        productoRepositorio.insertarProducto(prod);
        return listaProducto(model);
    }

    @RequestMapping("/formModificarProducto/{id}")
    public String formModificarProducto(Model model, @PathVariable String id){
        producto producto = productoRepositorio.getProductoPorId(Integer.parseInt(id));
        model.addAttribute("producto", producto);
        return "formModificarProducto";
    }

    @RequestMapping("/eliminarProducto/{id}")
    public String eliminarProducto(Model model, @PathVariable String id){
        producto producto = productoRepositorio.getProductoPorId(Integer.parseInt(id));
        productoRepositorio.eliminarProducto(producto);
        return listaProducto(model);
    }

    @RequestMapping("/actualizarProducto")
    public String actualizarProducto(producto producto, Model model){
        productoRepositorio.actualizarProducto(producto);
        return listaProducto(model);
    }

    public List<producto> getTodosProducto(){
        return productoRepositorio.getTodosProducto();
    }

    public producto getProductoPorId(int idProducto){
        return productoRepositorio.getProductoPorId(idProducto);
    }
}
