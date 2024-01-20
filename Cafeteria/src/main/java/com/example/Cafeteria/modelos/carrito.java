package com.example.Cafeteria.modelos;

import java.util.List;


public class carrito {
    private List<producto> productos;
    private double total;

    public carrito(List<producto> productos, double total) {
        this.productos = productos;
        this.total = total;
    }

    public carrito() {
    }

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public Object getId() {
        return null;
    }

    public void setId(int id) {
    }
}
