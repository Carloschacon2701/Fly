package org.carlos.flycommerce.Services.Chat;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.MongoDB.ChatRoom;
import org.carlos.flycommerce.Repository.MongoDB.ChatRoomRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public Optional<String> getChatRoomId(
            String senderId,
            String recipientId,
            boolean createIfNotExist
    ){
        return chatRoomRepository.findBySenderIdAndRecipientId(senderId,recipientId)
                .map(ChatRoom::getChatId)
                .or(() ->{
                        if(!createIfNotExist){
                            var chat = createChatId(senderId, recipientId);
                            return Optional.of(chat);
                        }

                        return Optional.empty();
                });
    }

    private String createChatId(String senderId, String recipientId){
        var chatId = String.format("%s_%s", senderId, recipientId);

        ChatRoom senderRecipient = ChatRoom.builder()
                .chatId(chatId)
                .senderId(senderId)
                .recipientId(recipientId)
                .build();

        ChatRoom recipientSender = ChatRoom.builder()
                .chatId(chatId)
                .senderId(recipientId)
                .recipientId(senderId)
                .build();

        chatRoomRepository.save(senderRecipient);
        chatRoomRepository.save(recipientSender);

        return chatId;
    }
}
