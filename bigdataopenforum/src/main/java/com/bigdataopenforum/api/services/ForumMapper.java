package com.bigdataopenforum.api.services;

import com.bigdataopenforum.api.domain.CommentPost;
import com.bigdataopenforum.api.domain.LikePost;
import com.bigdataopenforum.api.domain.Post;
import com.bigdataopenforum.api.repositories.post.entities.CommentEntity;
import com.bigdataopenforum.api.repositories.post.entities.LikeEntity;
import com.bigdataopenforum.api.repositories.post.entities.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ForumMapper {

    List<Post> mapToPosts(List<PostEntity> posts);

    List<PostEntity> mapToPostEntities(List<Post> posts);

    Post mapToPost(PostEntity post);

    PostEntity mapToPostEntity(Post post);

    CommentPost mapToComment(CommentEntity commentEntity);

    @Mapping(target = "post", ignore = true)
    CommentEntity mapToCommentEntity(CommentPost commentPost);

    LikePost mapToLike(LikeEntity post);

    @Mapping(target = "post", ignore = true)
    LikeEntity mapToLikeEntity(LikePost post);
}
