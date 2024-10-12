package com.example.apimongopeticos.Controllers;

import com.example.apimongopeticos.Models.Personalization;
import com.example.apimongopeticos.Service.PersonalizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personalizations")
public class PersonalizationController {

    @Autowired
    private PersonalizationService service;

    @GetMapping
    public List<Personalization> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personalization> getById(@PathVariable Long id) {
        Optional<Personalization> personalization = service.findById(id);
        if (personalization.isPresent()) {
            return ResponseEntity.ok(personalization.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Personalization create(@RequestBody Personalization personalization) {
        return service.save(personalization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personalization> update(@PathVariable Long id, @RequestBody Personalization personalization) {
        try {
            Personalization updatedPersonalization = service.update(id, personalization);
            return ResponseEntity.ok(updatedPersonalization);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

