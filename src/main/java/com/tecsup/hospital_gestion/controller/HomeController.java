package com.tecsup.hospital_gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Ruta principal del sistema
    @GetMapping("/")
    public String inicio() {
        return "inicio"; // Muestra la vista inicio.html
    }

    // También responde a /inicio
    @GetMapping("/inicio")
    public String mostrarInicio() {
        return "inicio";
    }
}
