package com.devblack.vinychat.bot.adapter;

import com.devblack.vinychat.core.bot.BotService;
import com.devblack.vinychat.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

@Service
public class BotServiceAdapter implements BotService {

    private static final String BOT_USERNAME = "bot";

    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public Message initCall(final Message message, final UUID token) {

        if (Objects.isNull(message.getTicketId()) || StringUtils.isEmpty(message.getTicketId())) {
            message.setTicketId(String.valueOf(token));
            message.setMessageBody(helloMessage());
            message.setSenderUser(BOT_USERNAME);
            message.setInitial(Boolean.TRUE);
        }

        return message;
    }

    @Override
    public Message initializeMessage(final Message message) {

        message.setMessageBody(helloMessage());
        message.setSenderUser(BOT_USERNAME);
        message.setInitial(Boolean.TRUE);

        return message;
    }

    @Override
    public Message menuOptions(final Message message) {
        return null;
    }

    @Override
    public boolean mediator(final Message message) {
        return false;
    }

    @Override
    public Message invokeAction(final Message message) {
        return null;
    }

    private static String helloMessage() {

        return "Olá, tudo bem?" +
                "\\n" +
                "Escolha algumas das opções abaixo para começar" +
                "\\n\\n" +
                "1 - Inserir nome de usuario" +
                "\\n" +
                "2 - Abrir Ticket de chat";
    }



}
