package com.example.apimongopeticos.Controllers;
import com.example.apimongopeticos.Models.Post;
import com.example.apimongopeticos.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")  // Define a rota base
public class PostController {

    @Autowired
    private PostService postService;

    // Endpoint para pegar todos os posts
    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Endpoint para inserir um novo post
    @PostMapping("/insert")
    public ResponseEntity<Post> insertPost(@RequestBody Post post) {
        Post savedPost = postService.insertPost(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
}