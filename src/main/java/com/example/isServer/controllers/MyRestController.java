package com.example.isServer.controllers;

import com.example.isServer.models.Post;
import com.example.isServer.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/get")
    @ResponseBody
    public Post json() {
        long id = 10;
        Post post = postRepository.findById(id).orElseThrow();
        return post;
    }

}
