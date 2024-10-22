package com.example.apimongopeticos.Controllers;
import com.example.apimongopeticos.Models.ApiResponseMongo;
import com.example.apimongopeticos.Models.Post;
import com.example.apimongopeticos.Service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/posts")  // Define a rota base
public class PostController {

    @Autowired
    private PostService postService;

    @Operation(summary = "Retorna todos os posts", description = "Busca todos os posts disponíveis no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Posts retornados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @Operation(summary = "Insere um novo post",
            description = "Adiciona um post ao banco de dados, fornecendo o conteúdo do post no corpo da requisição. Pode ser um post de produto (profissional) ou um post normal.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post inserido com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Post.class),
                    examples = {
                            @ExampleObject(name = "Post Normal", summary = "Exemplo de Post Normal",
                                    value = "{\n  \"userId\": \"102\",\n  \"likes\": 120,\n  \"shares\": 10,\n  \"picture\": \"https://example.com/image1.jpg\",\n  \"caption\": \"Um ótimo dia no parque com meus pets!\",\n  \"pets\": [\n    \"104\",\n    \"120\"\n  ],\n  \"postDate\": \"2024-10-16T12:34:56Z\",\n  \"is_mei\": false\n}"),

                            @ExampleObject(name = "Post de Produto", summary = "Exemplo de Post de Produto (Profissional)",
                                    value = "{\n  \"userId\": \"105\",\n  \"likes\": 85,\n  \"shares\": 15,\n  \"picture\": \"https://example.com/product_image.jpg\",\n  \"caption\": \"Produto especial para pets! Aproveite o desconto!\",\n  \"postDate\": \"2024-10-16T14:20:00Z\",\n  \"is_mei\": true,\n  \"price\": 99.99,\n  \"telephone\": \"+5511999999999\",\n  \"productName\": \"Brinquedo para cachorro\"\n}")
                    }
            )
    )
    @PostMapping("/insert")
    public ResponseEntity<ApiResponseMongo> insertPost(@RequestBody Post post) {
        Post savedPost = postService.insertPost(post);
        return ResponseEntity.ok(new ApiResponseMongo("Post inserido com sucesso!"));
    }

    @Operation(summary = "Retorna posts alternados", description = "Retorna posts intercalados, alternando entre 3 posts normais e 1 post de produto.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Posts alternados retornados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    @GetMapping("/alternado")
    public List<Post> getAlternativePosts() {
        return postService.getAlternativePosts();
    }

    @Operation(summary = "Insere um like para o Post", description = "Adiciona o username a lista de likes")
    @PutMapping("/{id}/like")
    public ResponseEntity<ApiResponseMongo> addLike(
            @Parameter(description = "ID do post", required = true) @PathVariable ObjectId id,
            @Parameter(description = "Username de quem deu o like", required = true) @RequestParam String username) {

        Optional<Post> optionalPost = postService.findById(id);

        if (!optionalPost.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseMongo("Post not found"));
        }

        Post post = optionalPost.get();

        // Verifica se o username já deu like
        if (!post.getLikes().contains(username)) {
            post.getLikes().add(username);
            postService.insertPost(post);
            return ResponseEntity.ok(new ApiResponseMongo("Like added successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponseMongo("User has already liked this post"));
        }
    }

    @Operation(summary = "Remove o like de um post", description = "Remove o username da lista de likes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like removed successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Post not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "409", description = "User has not liked this post",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    @PutMapping("/{id}/dislike")
    public ResponseEntity<ApiResponseMongo> removeLike(
            @PathVariable ObjectId id,
            @RequestParam String username
    ) {
        Optional<Post> optionalPost = postService.findById(id);

        if (!optionalPost.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseMongo("Post not found"));
        }

        Post post = optionalPost.get();

        if (post.getLikes().contains(username)) {
            post.getLikes().remove(username);
            postService.insertPost(post);
            return ResponseEntity.ok(new ApiResponseMongo("Like removed successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponseMongo("User has not liked this post"));
        }
    }

    @GetMapping("/findbyuserid/{id}")
    public List<Post> findByUserId(@PathVariable String id) {
        return postService.findByUserId(id); // Call the service method to fetch posts by user ID
    }

    @PutMapping("/share/{id}")
    public ResponseEntity<ApiResponseMongo> incrementPostShares(@PathVariable("id") String postId) {
        postService.share(postId);
        return ResponseEntity.ok(new ApiResponseMongo("Compartilhado com sucesso"));
    }
}