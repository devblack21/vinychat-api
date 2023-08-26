package com.devblack.vinychat.chat.controller;

import com.devblack.vinychat.chat.dto.MessageDTO;
import com.devblack.vinychat.chat.dto.MessageListResponse;
import com.devblack.vinychat.chat.mapper.MessageDTOMapper;
import com.devblack.vinychat.repository.adapter.MessageRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.devblack.vinychat.core.constants.ApplicationContants.APPLICATION_JSON;
import static com.devblack.vinychat.core.routes.Routes.BACKUP_MESSAGES;

@RestController
@RequestMapping
@CrossOrigin(value = "*")
public class MessageChatController {

    private final MessageRepository repository = new MessageRepository();

    @GetMapping(value = BACKUP_MESSAGES,
      consumes = APPLICATION_JSON,
      produces = APPLICATION_JSON)
    public ResponseEntity<MessageListResponse> getMessages(@PathVariable("ticket") String ticket) {

        final List<MessageDTO> messages = MessageDTOMapper.INSTANCE.mapFrom(repository.getMessages(UUID.fromString(ticket)));

        return ResponseEntity.ok(new MessageListResponse(messages));
    }

}
