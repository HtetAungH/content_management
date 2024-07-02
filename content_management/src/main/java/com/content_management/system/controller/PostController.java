package com.content_management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.content_management.system.model.PostModel;
import com.content_management.system.service.PostService;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable Long id, Model model) {
        PostModel post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @GetMapping("/admin/createPost")
    public String createPostForm(Model model) {
        model.addAttribute("postModel", new PostModel());
        return "createPost";
    }

    @PostMapping("/admin/createPost")
    public String createPost(@ModelAttribute PostModel postModel) {
        postService.createPost(postModel);
        return "redirect:/posts";
    }
}
