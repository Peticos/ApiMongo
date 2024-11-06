package com.example.apimongopeticos.Repositories;

import com.example.apimongopeticos.Models.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, ObjectId> {

    List<Post> findByIs_meiFalse();
    List<Post> findByIs_meiTrue();
    List<Post> findByUser_id(String id);


    Optional<Post> findById(String objectId);
}

