package com.bigdataopenforum.api.controllers;

import com.bigdataopenforum.api.domain.CommentPost;
import com.bigdataopenforum.api.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forum")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CommentController {

    private final CommentService commentService;

    // localhost:9090/api/forum/post/1
    @PostMapping(value = "/posts/{postId}/comment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addComment(@RequestBody CommentPost comment, @PathVariable(value = "postId") Long postId) {

        return new ResponseEntity<>(commentService.addComment(comment, postId), HttpStatus.OK);
    }

}
