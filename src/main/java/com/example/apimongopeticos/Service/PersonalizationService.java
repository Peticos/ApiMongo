package com.example.apimongopeticos.Service;
import com.example.apimongopeticos.Models.Personalization;
import com.example.apimongopeticos.Repositories.PersonalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalizationService {

    @Autowired
    private PersonalizationRepository repository;

    public List<Personalization> findAll() {
        return repository.findAll();
    }

    public Optional<Personalization> findById(Long id) {
        return repository.findById(id);
    }

    public Personalization save(Personalization personalization) {
        return repository.save(personalization);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Personalization update(Long id, Personalization updatedPersonalization) {
        if (repository.existsById(id)) {
            updatedPersonalization.setId(id);
            return repository.save(updatedPersonalization);
        } else {
            throw new RuntimeException("Personalization not found");
        }
    }
}
