package org.carlos.flycommerce.Repository.MongoDB;

import org.carlos.flycommerce.Models.MongoDB.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    List<ChatMessage> findByChatId (String chatId);
}
