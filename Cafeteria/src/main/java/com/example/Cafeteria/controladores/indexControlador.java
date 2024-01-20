package com.example.Cafeteria.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

public class indexControlador {

    @RequestMapping("/")
    public String inicio(){

        return "index";
    }
}
