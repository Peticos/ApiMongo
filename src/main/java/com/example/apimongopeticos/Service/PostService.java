package com.example.apimongopeticos.Service;

import com.example.apimongopeticos.Models.Post;
import com.example.apimongopeticos.Repositories.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post insertPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findByUser_id(BigInteger id){
        return postRepository.findByUserId(id);
    }

    public void share(String id, String username) {
        // Busca o post pelo ID
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {

            Post post = optionalPost.get();

            post.getShares().add(username);
            postRepository.save(post);
        } else {
            throw new RuntimeException("Post não encontrado com o ID: ");
        }
    }


    public Optional<Post> findById(ObjectId id) {
        return postRepository.findById(id);
    }
}