package com.example.isServer.controllers;

import com.example.isServer.models.Post;
import com.example.isServer.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home Page");
        return "home";
    }

    @GetMapping("/blog/blog-main")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add-post")
    public String addPost(Model model) {
        return "post-add";
    }

    @PostMapping("/blog/add-post")
    public String mappingPostAddPost(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model) {
        Post post = new Post(title, anons, fullText, 0);
        postRepository.save(post);
        return "redirect:/blog/blog-main";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {

        if (!postRepository.existsById(id)) {
            return "redirect:/blog/blog-main";
        }


        Post post = postRepository.findById(id).orElseThrow();
        post.setViews(post.getViews() + 1);

        model.addAttribute("post", post);
        return "post-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {

        if (!postRepository.existsById(id)) {
            return "redirect:/blog/blog-main";
        }

//        Optional<Post> post = postRepository.findById(id);
//        ArrayList<Post> res = new ArrayList<>();
//        post.ifPresent(res::add);

        Post post = postRepository.findById(id).orElseThrow();

        model.addAttribute("post", post);

        return "post-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String mappingPostBlogEdit(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model) {

        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);

        postRepository.save(post);

        return "redirect:/blog/blog-main";
    }

    @PostMapping("/blog/{id}/remove")
    public String mappingPostBlogDel(@PathVariable(value = "id") long id, Model model) {

        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);

        return "redirect:/blog/blog-main";
    }



}
