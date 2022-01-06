package com.bigdataopenforum.api.services;

import com.bigdataopenforum.api.domain.CommentPost;
import com.bigdataopenforum.api.repositories.post.CommentRepository;
import com.bigdataopenforum.api.repositories.post.PostRepository;
import com.bigdataopenforum.api.repositories.post.entities.CommentEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ForumMapper forumMapper;

    @Transactional
    public CommentPost addComment(CommentPost comment, Long postId) {
        CommentEntity commentEntity = forumMapper.mapToCommentEntity(comment);

        return postRepository.findById(postId)
                .map(postEntity -> {
                    commentEntity.setPost(postEntity);
                    return forumMapper.mapToComment(commentRepository.save(commentEntity));
                })
                .orElseThrow(() -> new RuntimeException(String.format("No post find with the identifier %s", postId)));

    }
}
