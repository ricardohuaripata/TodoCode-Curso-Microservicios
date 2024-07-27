package com.todocodeacademy.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.posts.model.Post;
import com.todocodeacademy.posts.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getPostsByUser(Long user) {
        return postRepository.findByUser(user);

    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

}
