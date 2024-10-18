package com.example.apimongopeticos.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auth")
public class Auth {

    @Id
    private String Id;
    private String email;
    private String senha;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
        Id = id;
        this.email = email;
        this.senha = senha;
    }

    public Auth() {
    }
}
