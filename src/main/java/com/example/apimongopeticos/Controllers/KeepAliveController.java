package com.example.apimongopeticos.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeepAliveController {

    @Operation(summary = "endpoint para keep alive", description = "Verifica se a aplicação está ativa")
    @GetMapping()
    public String keepAlive() {
        return "Aplicação ativa";}
}
