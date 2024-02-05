package com.example.Cafeteria.modelos;

public class Carrito {
    private int id;
    private int productos;
    private double total;


    public Carrito(int id, int productos, double total) {
        this.id = id;
        this.productos = productos;
        this.total = total;
    }

    public Carrito() {
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public double getProductos() {
        return productos;
    }

    public void setProductos(int productos) {
        this.productos = productos;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
