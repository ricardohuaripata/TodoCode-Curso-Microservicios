package com.todocodeacademy.users.dto;

import java.util.List;

import com.todocodeacademy.users.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String cellphone;
    private String lastname;
    private String name;
    private List<Post> posts;
}
