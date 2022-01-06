package com.bigdataopenforum.api.repositories.post.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_comment_fk", nullable = false)
    @JsonIgnore
    private PostEntity post;

}
