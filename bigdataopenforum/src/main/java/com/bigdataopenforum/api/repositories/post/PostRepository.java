package com.bigdataopenforum.api.repositories.post;

import com.bigdataopenforum.api.repositories.post.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
