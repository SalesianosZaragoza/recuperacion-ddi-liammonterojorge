package com.example.Cafeteria.modelos;

import java.sql.Date;

public class Carrito {
    private int id;
    private String estado;
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    private Date fecha;

    


    public Carrito(int id, String estado, Date fecha ) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Carrito() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
