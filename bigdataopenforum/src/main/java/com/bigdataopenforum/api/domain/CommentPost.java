package com.bigdataopenforum.api.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CommentPost {

    private Long id;

    private String username;

    private String content;
}
