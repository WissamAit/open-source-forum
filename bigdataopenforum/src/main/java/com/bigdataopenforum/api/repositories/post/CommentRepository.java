package com.bigdataopenforum.api.repositories.post;

import com.bigdataopenforum.api.repositories.post.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
