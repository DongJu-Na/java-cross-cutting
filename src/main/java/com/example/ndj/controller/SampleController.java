package com.example.ndj.controller;

import com.example.ndj.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
@AllArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/posts")
    public String getPosts() {
        return sampleService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id) {
        return sampleService.getPostById(id);
    }

    @GetMapping("/posts/{id}/comments")
    public String getCommentsForPost(@PathVariable long id) {
        return sampleService.getCommentsForPost(id);
    }

    @GetMapping("/comments")
    public String getCommentsByPostId(@RequestParam long postId) {
        return sampleService.getCommentsByPostId(postId);
    }

    @PostMapping("/posts")
    public String createPost(@RequestBody String postJson) {
        return sampleService.createPost(postJson);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable long id, @RequestBody String postJson) {
        sampleService.updatePost(id, postJson);
    }

    @PatchMapping("/posts/{id}")
    public void patchPost(@PathVariable long id, @RequestBody String postJson) {
        sampleService.patchPost(id, postJson);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id) {
        sampleService.deletePost(id);
    }
}