package com.example.apimongopeticos.Repositories;

import com.example.apimongopeticos.Models.Auth;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository extends MongoRepository<Auth,String> {

    Auth findByEmail(String email);

}
