package com.example.apimongopeticos.Controllers;

import com.example.apimongopeticos.Models.ApiResponseMongo;
import com.example.apimongopeticos.Models.Auth;
import com.example.apimongopeticos.Service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Operation(summary = "Registrar um novo usuário", description = "Este endpoint registra um novo usuário com email e senha.")
    @PostMapping("/register")
    public ResponseEntity<ApiResponseMongo> registerUser(@RequestBody Auth auth) {
        try {
            authService.insert(auth);
            return ResponseEntity.ok(new ApiResponseMongo("Usuário registrado com sucesso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body( new ApiResponseMongo("Erro ao registrar"));
        }
    }

    @Operation(summary = "Autenticar usuário", description = "Este endpoint autentica um usuário comparando email e senha.")
    @PostMapping("/login")
    public Integer loginUser(@RequestBody Auth auth) {
        Integer isAuthenticated = authService.authenticate(auth);

        return  isAuthenticated;

    }
}
