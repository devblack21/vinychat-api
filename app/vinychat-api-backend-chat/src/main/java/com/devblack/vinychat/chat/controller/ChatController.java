package com.devblack.vinychat.chat.controller;

import com.devblack.vinychat.chat.dto.MessageDTO;
import com.devblack.vinychat.chat.mapper.MessageDTOMapper;
import com.devblack.vinychat.chat.mapper.MessageMapper;
import com.devblack.vinychat.core.processor.HandshakeProcessor;
import com.devblack.vinychat.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.devblack.vinychat.core.constants.ApplicationContants.APPLICATION_JSON;
import static com.devblack.vinychat.core.routes.Routes.HANDSHAKE;

@RestController
@CrossOrigin("*")
public class ChatController {

    @Autowired
    private HandshakeProcessor handshakeProcessor;

    @PostMapping(value = HANDSHAKE,
      consumes = APPLICATION_JSON,
      produces = APPLICATION_JSON)
    public MessageDTO handshake(@RequestBody final MessageDTO requestBody){

        final Message messageDomain = MessageMapper.INSTANCE.mapFrom(requestBody);

        handshakeProcessor.invoke(messageDomain);

        return MessageDTOMapper.INSTANCE.mapFrom(messageDomain);
    }

}
