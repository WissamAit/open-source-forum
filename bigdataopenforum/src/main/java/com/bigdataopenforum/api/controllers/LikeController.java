package com.bigdataopenforum.api.controllers;

import com.bigdataopenforum.api.domain.LikePost;
import com.bigdataopenforum.api.services.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/forum")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LikeController {

    private final LikeService likeService;

    // localhost:9090/api/forum/posts/1/like
    @PostMapping(value = "/posts/{postId}/like", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addComment(@RequestBody LikePost like, @PathVariable(value = "postId") Long postId) {

        return new ResponseEntity<>(likeService.updateLike(like, postId), HttpStatus.OK);
    }

}
