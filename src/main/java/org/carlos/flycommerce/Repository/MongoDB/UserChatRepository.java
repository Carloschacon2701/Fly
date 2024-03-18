package org.carlos.flycommerce.Repository.MongoDB;

import org.carlos.flycommerce.Models.MongoDB.StatusMongo;
import org.carlos.flycommerce.Models.MongoDB.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserChatRepository extends MongoRepository<UserMongo, String> {
    List<UserMongo> findAllByStatus(StatusMongo status);
}
