package com.todocodeacademy.users.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.users.dto.UserDto;
import com.todocodeacademy.users.feign.PostsClient;
import com.todocodeacademy.users.model.Post;
import com.todocodeacademy.users.model.User;
import com.todocodeacademy.users.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostsClient postsClient;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDto getUserPosts(Long id) {
        User targetUser = getUserById(id);
        if (targetUser == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(targetUser.getId());
        userDto.setName(targetUser.getName());
        userDto.setLastname(targetUser.getLastname());

        userDto.setCellphone(targetUser.getCellphone());
        List<Post> posts = postsClient.getPostsByUserId(id);
        userDto.setPosts(posts);

        return userDto;
    }

}
