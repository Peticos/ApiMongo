package com.example.apimongopeticos.Controllers;

import com.example.apimongopeticos.Models.ApiResponseMongo;
import com.example.apimongopeticos.Models.Personalization;
import com.example.apimongopeticos.Service.PersonalizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personalizations")
public class PersonalizationController {

    @Autowired
    private PersonalizationService service;

    @Operation(summary = "Recupera todas as personalizações",
            description = "Retorna uma lista de todas as personalizações cadastradas no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personalizações recuperadas com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/getall")
    public List<Personalization> getAll() {
        return service.findAll();
    }

    @Operation(summary = "Recupera uma personalização pelo ID",
            description = "Retorna uma personalização pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personalização recuperada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Personalização não encontrada",
                    content = @Content(examples = @ExampleObject(value = "Personalização não encontrada"))),})
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Personalization> getById(@PathVariable Long id) {
        Optional<Personalization> personalization = service.findById(id);
        if (personalization.isPresent()) {
            return ResponseEntity.ok(personalization.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Insere uma nova personalização", description = "Insere uma nova personalização no banco de dados")
    @PostMapping("/insert")
    public ResponseEntity<ApiResponseMongo> create(@RequestBody Personalization personalization) {
        service.save(personalization);

        return ResponseEntity.ok(new ApiResponseMongo("Personalização criada com sucesso"));
    }

    @Operation(summary = "Atualiza uma personalização pelo ID", description = "Atualiza uma personalização pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personalização atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Personalização não encontrada",
                    content = @Content(examples = @ExampleObject(value = "Personalização não encontrada"))),})
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponseMongo> update(@PathVariable Long id, @RequestBody Personalization personalization) {
        try {
            Personalization updatedPersonalization = service.update(id, personalization);
            return ResponseEntity.ok(new ApiResponseMongo("Personalização atualizada com sucesso"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseMongo(e.getMessage()));
        }
    }

    @Operation(summary = "Exclui uma personalização pelo ID", description = "Exclui uma personalização pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Personalização excluída com sucesso"),
            @ApiResponse(responseCode = "404", description = "Personalização não encontrada",
                    content = @Content(examples = @ExampleObject(value = "Personalização não encontrada"))),})
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponseMongo> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok(new ApiResponseMongo("Personalização excluída com sucesso"));
    }
}

