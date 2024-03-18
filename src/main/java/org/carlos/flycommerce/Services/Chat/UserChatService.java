package org.carlos.flycommerce.Services.Chat;

import lombok.RequiredArgsConstructor;
import org.carlos.flycommerce.Models.MongoDB.UserMongo;
import org.carlos.flycommerce.Repository.MongoDB.UserChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.carlos.flycommerce.Models.MongoDB.StatusMongo.OFFLINE;
import static org.carlos.flycommerce.Models.MongoDB.StatusMongo.ONLINE;

@Service
@RequiredArgsConstructor
public class UserChatService {
    private final UserChatRepository userChatRepository;

    public void saveUser(UserMongo user) {
        user.setStatus(ONLINE);
        userChatRepository.save(user);
    }

    public void disconnect(UserMongo user){
        var storedUser = userChatRepository.findById(user.getName())
                .orElse(null);

        if (storedUser != null) {
            storedUser.setStatus(OFFLINE);
            userChatRepository.save(storedUser);
        }
    }

    public List<UserMongo> getOnlineUsers() {
        return userChatRepository.findAllByStatus(ONLINE);
    }
}
