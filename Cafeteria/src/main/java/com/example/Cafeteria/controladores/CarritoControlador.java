package com.example.Cafeteria.controladores;

import com.example.Cafeteria.modelos.Carrito;
import com.example.Cafeteria.modelos.Producto;
import com.example.Cafeteria.repositorio.CarritoRepositorio;
import com.example.Cafeteria.repositorio.ProductoRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CarritoControlador {

    @Autowired
    CarritoRepositorio carritoRepositorio;

    @Autowired
    ProductoRepositorio productoRepositorio;

    @Autowired
    HttpSession session;

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


    @PostMapping("/insertarCarrito/{idProducto}")
    public ResponseEntity<String> insertarCarrito(@PathVariable String idProducto, Model model){
        // Obtén el Carrito actual del usuario
        Carrito carrito = obtenerCarritoActual(session);

        // Obtén el Producto seleccionado
        Producto producto = productoRepositorio.getProductoPorId(Integer.parseInt(idProducto));

        // Agrega el Producto al Carrito
        carritoRepositorio.agregarProductoAlCarrito(carrito, producto);

        // Log para verificar que el producto se agregó correctamente
        System.out.println("Producto " + producto.getNombre() + " agregado al carrito");

        // Actualiza el total del Carrito
        carrito.setTotal(carrito.getTotal() + producto.getPrecio());

        // Guarda el Carrito actualizado
        carritoRepositorio.actualizarCarrito(carrito);

        return ResponseEntity.ok("Producto agregado al carrito");
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

    @RequestMapping("/verCarrito")
    public String verCarrito(Model model){
        // Obtén el Carrito actual del usuario
        Carrito carrito = obtenerCarritoActual(session);

        // Obtén los Productos del Carrito
        List<Producto> productos = carritoRepositorio.getProductosDelCarrito(carrito);

        // Pasa los Productos a la vista
        model.addAttribute("productos", productos);

        return "verCarrito";
    }

    private Carrito obtenerCarritoActual(HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }

        return carrito;
    }
}

