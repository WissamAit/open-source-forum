package com.bigdataopenforum.api.services;

import com.bigdataopenforum.api.domain.LikePost;
import com.bigdataopenforum.api.repositories.post.LikeRepository;
import com.bigdataopenforum.api.repositories.post.PostRepository;
import com.bigdataopenforum.api.repositories.post.entities.LikeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final ForumMapper forumMapper;

    @Transactional
    public LikePost updateLike(LikePost like, Long postId) {
        LikeEntity likeEntity = forumMapper.mapToLikeEntity(like);

        Optional<LikeEntity> foundLike = likeRepository.findByUsernameAndPostId(like.getUsername(), postId);
        if (foundLike.isPresent()) {
            foundLike.ifPresent(foundLikeEntity -> likeRepository.deleteById(foundLikeEntity.getId()));
            return like;
        }
        return postRepository.findById(postId)
                .map(postEntity -> {
                    likeEntity.setPost(postEntity);
                    return forumMapper.mapToLike(likeRepository.save(likeEntity));
                })
                .orElseThrow(() -> new RuntimeException(String.format("No post find with the identifier %s", postId)));
    }

}
