package com.example.operaciones.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "resultados", url = "localhost:9001")
public interface ResultadoClienteRest {
    @GetMapping("/resultado/{numero}")
   public String mostrarResultado (@PathVariable Float numero);
}
