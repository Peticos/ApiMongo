package com.example.apimongopeticos.Service;

import com.example.apimongopeticos.Models.Post;
import com.example.apimongopeticos.Repositories.PostRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Post> findByUser_id(String id){
        return postRepository.findByUser_id(id);
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

    public List<Post> getAlternativePosts() {
        List<Post> meiFalsePosts = postRepository.findByIs_meiFalse();
        List<Post> meiTruePosts = postRepository.findByIs_meiTrue();

        List<Post> result = new ArrayList<>();
        int minLength = Math.min(meiFalsePosts.size() / 3, meiTruePosts.size());

        for (int i = 0; i < minLength; i++) {
            // Adiciona 3 posts onde is_mei é false
            result.add(meiFalsePosts.get(i * 3));
            result.add(meiFalsePosts.get(i * 3 + 1));
            result.add(meiFalsePosts.get(i * 3 + 2));


            result.add(meiTruePosts.get(i));
        }

        return result;
    }

    public Optional<Post> findById(ObjectId id) {
        return postRepository.findById(id);
    }
}