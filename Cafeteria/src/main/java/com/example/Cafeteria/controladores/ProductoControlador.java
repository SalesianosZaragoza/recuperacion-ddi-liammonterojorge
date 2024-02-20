package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.Producto;
import com.example.Cafeteria.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductoControlador {


    @Autowired
    ProductoRepositorio productoRepositorio;

    @RequestMapping("/listarProducto")
    public String listaProducto(Model model){
        List<Producto> listaProducto = productoRepositorio.getTodosProducto();
        model.addAttribute("listaProducto", listaProducto);
        return "listaProducto";
    }

    @RequestMapping("/listarProductoPublica")
    public String listaProductoPublica(Model model){
        List<Producto> listaProducto = productoRepositorio.getTodosProducto();
        model.addAttribute("listaProducto", listaProducto);
        return "listaProductoPublica";
    }

    @RequestMapping("/listarProductoPrivate")
    public String listaProductoPrivate(Model model){
        List<Producto> listaProducto = productoRepositorio.getTodosProducto();
        model.addAttribute("listaProductoPrivate", listaProducto);
        return "listaProductoPrivate";
    }

    @RequestMapping("/formInsertarProducto")
    public String formInsertarProducto(Model model){
        Producto producto = new Producto();
        model.addAttribute("nuevoProducto", producto);
        return "formProducto";
    }

    @RequestMapping("/insertarProducto")
    public String insertarProducto(Producto prod, Model model){
        productoRepositorio.insertarProducto(prod);
        return listaProducto(model);
    }

    @RequestMapping("/formModificarProducto/{id}")
    public String formModificarProducto(Model model, @PathVariable String id){
        Producto producto = productoRepositorio.getProductoPorId(Integer.parseInt(id));
        model.addAttribute("producto", producto);
        return "formModificarProducto";
    }

    @RequestMapping("/eliminarProducto/{id}")
    public String eliminarProducto(Model model, @PathVariable String id){
        Producto producto = productoRepositorio.getProductoPorId(Integer.parseInt(id));
        productoRepositorio.eliminarProducto(producto);
        return listaProducto(model);
    }

    @RequestMapping("/actualizarProducto")
    public String actualizarProducto(Producto producto, Model model){
        productoRepositorio.actualizarProducto(producto);
        return listaProducto(model);
    }

    public List<Producto> getTodosProducto(){
        return productoRepositorio.getTodosProducto();
    }

    public Producto getProductoPorId(int idProducto){
        return productoRepositorio.getProductoPorId(idProducto);
    }
}
