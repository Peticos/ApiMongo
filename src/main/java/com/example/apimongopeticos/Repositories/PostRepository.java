package com.example.apimongopeticos.Repositories;

import com.example.apimongopeticos.Models.Post;
import com.example.apimongopeticos.Service.PostService;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public interface PostRepository extends MongoRepository<Post, ObjectId> {

    List<Post> findByIsMeiFalse();
    List<Post> findByIsMeiTrue();
    List<Post> findByUserId(String id);


    Optional<Post> findById(String objectId);
}

