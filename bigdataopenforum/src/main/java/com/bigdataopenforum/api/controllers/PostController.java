package com.bigdataopenforum.api.controllers;

import com.bigdataopenforum.api.domain.Post;
import com.bigdataopenforum.api.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forum/post")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;

    // localhost:9090/api/forum/post
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addPost(@RequestBody Post post) {

        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    // localhost:9090/api/forum/post/all
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllPosts() {

        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    // localhost:9090/api/forum/post/1
    @DeleteMapping(value = "/{postId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteById(@PathVariable(value = "postId") Long postId) {

        postService.deleteById(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
