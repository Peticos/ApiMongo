package com.example.apimongopeticos.Repositories;

import com.example.apimongopeticos.Models.Personalization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalizationRepository extends MongoRepository<Personalization, Long> {
}