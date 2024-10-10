package com.example.apimongopeticos.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.apimongopeticos.Models.Post;
import com.example.apimongopeticos.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private static final Logger logger = LoggerFactory.getLogger(PostService.class);


    // Método para pegar todos os posts
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // Método para inserir um novo post
    public Post insertPost(Post post) {


        return postRepository.save(post);  // save é usado tanto para insert quanto para update
    }
}