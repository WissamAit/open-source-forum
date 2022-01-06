package com.bigdataopenforum.api.repositories.user.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "metadata")
@AllArgsConstructor
@Data
@Builder
public class UserMetadata {
    @Id
    private String id;

    private String username;

    private String connectionTime;

    private String action;

    private String location;

    private String navigator;
}
