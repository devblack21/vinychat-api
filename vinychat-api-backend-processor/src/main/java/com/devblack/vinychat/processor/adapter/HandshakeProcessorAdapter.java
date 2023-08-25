package com.devblack.vinychat.processor.adapter;

import com.devblack.vinychat.core.bot.BotService;
import com.devblack.vinychat.core.processor.HandshakeProcessor;
import com.devblack.vinychat.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HandshakeProcessorAdapter implements HandshakeProcessor {

    @Autowired
    private BotService botService;

    @Override
    public Message invoke(final Message message) {
        return botService.initCall(message, generateToken());
    }

    private UUID generateToken() {
        return UUID.randomUUID();
    }

}
