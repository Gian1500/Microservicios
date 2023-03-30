package com.example.operaciones.controllers;

import com.example.operaciones.clientes.ResultadoClienteRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OperacionController {
    @Autowired
    private RestTemplate clienteRest;
    @Autowired
    private ResultadoClienteRest clienteFeign;
    @GetMapping("/sumar")
    public String sumar (@RequestParam float a, @RequestParam float b){
        String resultado = Float.toString(a+b);
        return clienteRest.getForObject("http://localhost:9001/resultado/" + resultado, String.class);
    }
    @GetMapping("/restar")
    public String restar (@RequestParam float a, @RequestParam float b){
        return clienteFeign.mostrarResultado(a-b);
    }
}
