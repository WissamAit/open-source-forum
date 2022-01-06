package com.bigdataopenforum.api.repositories.user;

import com.bigdataopenforum.api.repositories.user.entities.UserMetadata;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMetadataRepository extends MongoRepository<UserMetadata, String> {
}
