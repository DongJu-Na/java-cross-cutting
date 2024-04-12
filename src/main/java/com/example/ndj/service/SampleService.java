package com.example.ndj.service;

import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class SampleService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private final RestTemplate restTemplate;

    public String getPosts() {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/posts", String.class);
        return response.getBody();
    }

    public String getPostById(long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/posts/" + id, String.class);
        return response.getBody();
    }

    public String getCommentsForPost(long postId) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/posts/" + postId + "/comments", String.class);
        return response.getBody();
    }

    public String getCommentsByPostId(long postId) {
        ResponseEntity<String> response = restTemplate.getForEntity(BASE_URL + "/comments?postId=" + postId, String.class);
        return response.getBody();
    }

    public String createPost(String postJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(postJson, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL + "/posts", HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }

    public void updatePost(long id, String postJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(postJson, headers);
        restTemplate.put(BASE_URL + "/posts/" + id, requestEntity);
    }

    public void patchPost(long id, String postJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(postJson, headers);
        restTemplate.exchange(BASE_URL + "/posts/" + id, HttpMethod.PATCH, requestEntity, Void.class);
    }

    public void deletePost(long id) {
        restTemplate.delete(BASE_URL + "/posts/" + id);
    }

}
