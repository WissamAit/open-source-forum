package com.bigdataopenforum.api.repositories.post;

import com.bigdataopenforum.api.repositories.post.entities.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    Optional<LikeEntity> findByUsernameAndPostId(String username, Long postId);
}
