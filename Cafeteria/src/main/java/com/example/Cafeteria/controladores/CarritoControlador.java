package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.Carrito;
import com.example.Cafeteria.modelos.Producto;
import com.example.Cafeteria.repositorio.CarritoRepositorio;
import com.example.Cafeteria.repositorio.ProductoRepositorio;
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

    @Autowired
    ProductoRepositorio productoRepositorio;

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

    @RequestMapping("/insertarCarrito/{idProducto}")
    public String insertarCarrito(@PathVariable String idProducto, Model model){
        // Obtén el Carrito actual del usuario
        Carrito carrito = obtenerCarritoActual();

        // Obtén el Producto seleccionado
        Producto producto = productoRepositorio.getProductoPorId(Integer.parseInt(idProducto));

        // Agrega el Producto al Carrito
        carritoRepositorio.agregarProductoAlCarrito(carrito, producto);

        // Actualiza el total del Carrito
        carrito.setTotal(carrito.getTotal() + producto.getPrecio());

        // Guarda el Carrito actualizado
        carritoRepositorio.actualizarCarrito(carrito);

        return "redirect:/listarProducto"; // Redirige de nuevo a la lista de productos
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

    private Carrito obtenerCarritoActual() {
        // Implementa esta función para obtener el Carrito actual del usuario
        // Esto puede implicar buscar el Carrito en la sesión del usuario, o buscar el último Carrito creado por el usuario en la base de datos
        return null;
    }
}

