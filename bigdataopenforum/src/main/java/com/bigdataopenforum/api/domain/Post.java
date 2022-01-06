package com.bigdataopenforum.api.domain;

import com.bigdataopenforum.api.repositories.post.entities.CommentEntity;
import com.bigdataopenforum.api.repositories.post.entities.LikeEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Post {

    private Long id;

    private String username;

    private String topic;

    private String message;

    private String hashtags;

    private LocalDateTime creationDate;

    @Singular
    private Set<LikeEntity> likes;

    @Singular
    private Set<CommentEntity> comments;
}
