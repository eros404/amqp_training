package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMessageController {
    private final ChatMessageRepository chatMessageRepository;
    public ChatMessageController(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }
    @GetMapping("/api/message")
    public Iterable<String> getLastTenMessages() {
        return chatMessageRepository.getLastTenMessages();
    }
}
