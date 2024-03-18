package org.carlos.flycommerce.Models.MongoDB;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ChatNotification {
    @Id
    private String id;
    private String senderId;
    private String recipientId;
    private String content;
}
