package com.todocodeacademy.users.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.todocodeacademy.users.model.Post;

// Mismo nombre de la app en eureka
// Asi ya no es necessario configurar la url
@FeignClient(name="posts-service", path = "/posts")
public interface PostsClient {
    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUserId(@PathVariable Long userId);
}
