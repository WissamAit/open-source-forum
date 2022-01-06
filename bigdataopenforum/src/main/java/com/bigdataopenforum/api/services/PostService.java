package com.bigdataopenforum.api.services;

import com.bigdataopenforum.api.domain.Post;
import com.bigdataopenforum.api.repositories.post.PostRepository;
import com.bigdataopenforum.api.repositories.post.entities.PostEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ForumMapper forumMapper;

    public Post createPost(Post post) {

        PostEntity entity = forumMapper.mapToPostEntity(post);
        entity.setCreationDate(LocalDateTime.now());
        return forumMapper.mapToPost(postRepository.save(entity));
    }

    @Transactional
    public List<Post> getPosts() {
        return forumMapper.mapToPosts(postRepository.findAll());
    }

    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }
}
