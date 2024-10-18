package com.example.apimongopeticos.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auth")
public class Auth {

    @Id
    private String id;
    private String email;
    private String senha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Auth(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Auth(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Auth() {
    }
}
