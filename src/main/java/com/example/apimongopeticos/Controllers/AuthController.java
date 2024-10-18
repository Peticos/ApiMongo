package com.example.apimongopeticos.Controllers;

import com.example.apimongopeticos.Models.Auth;
import com.example.apimongopeticos.Service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Operation(summary = "Registrar um novo usuário", description = "Este endpoint registra um novo usuário com email e senha.")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Auth auth) {
        try {
            authService.insert(auth);
            return new ResponseEntity<>("Usuário registrado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Autenticar usuário", description = "Este endpoint autentica um usuário comparando email e senha.")
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Auth auth) {
        boolean isAuthenticated = authService.authenticate(auth);
        if (isAuthenticated) {
            return new ResponseEntity<>("Login realizado com sucesso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Email ou senha incorretos", HttpStatus.UNAUTHORIZED);
        }
    }
}
