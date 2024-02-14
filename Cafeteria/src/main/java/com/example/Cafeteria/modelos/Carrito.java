package com.example.Cafeteria.modelos;

public class Carrito {
    private int id;
    private double total;


    public Carrito(int id, double total) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
