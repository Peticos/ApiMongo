package com.example.apimongopeticos.Service;

import com.example.apimongopeticos.Models.Auth;
import com.example.apimongopeticos.Models.Post;
import com.example.apimongopeticos.Repositories.AuthRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private AuthRepository authRepository;

    public AuthService (AuthRepository authRepository){
        this.authRepository=authRepository;
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void insert(Auth auth) {
        // Criptografa a senha antes de inserir
        String encodedPassword = passwordEncoder.encode(auth.getSenha());
        auth.setSenha(encodedPassword);
        authRepository.insert(auth);
    }

    // Método para autenticação (comparar email e senha)
    public Integer authenticate(Auth rawAuth) {
        Auth auth = authRepository.findByEmail(rawAuth.getEmail());
        if (auth != null) {
            // Compara a senha fornecida com a senha criptografada armazenada
            if (passwordEncoder.matches(rawAuth.getSenha(), auth.getSenha())){
                return auth.getId();
            }
            return -1;
        }
        return -1;
    }
}
