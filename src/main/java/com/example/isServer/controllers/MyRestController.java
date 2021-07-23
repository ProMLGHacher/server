package com.example.isServer.controllers;

import com.example.isServer.models.Post;
import com.example.isServer.models.TestData;
import com.example.isServer.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/hello")
    @ResponseBody
    public TestData testData(@RequestParam String hello, @RequestParam String name) {
        return new TestData(hello, name);
    }

    @PostMapping(value = "/hello/1")
    public TestData testData2(@RequestBody TestData test) {
        return test;
    }

}
