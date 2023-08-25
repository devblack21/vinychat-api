package com.devblack.vinychat.repository.adapter;

import com.devblack.vinychat.chat.dto.MessageDTO;
import com.devblack.vinychat.domain.Message;

import java.util.*;

public class MessageRepository {

    private static final Map<String, List<Message>> messagesBD = new HashMap<>();

    public void addMessage(final Message message) {

        if (!messagesBD.containsKey(message.getTicketId())) {
            messagesBD.put(message.getTicketId(), new ArrayList<>());
        }

        if (message.getInitial()) {
            if (!containsInitial(message)) {
              System.out.println("add message: " + message);
              messagesBD.get(message.getTicketId()).add(message);
            }
        } else {
          System.out.println("add message: " + message);
          messagesBD.get(message.getTicketId()).add(message);
        }

    }


    private boolean containsInitial(final Message message) {
        return messagesBD.get(message.getTicketId())
                .stream()
                .anyMatch(Message::getInitial);
    }

    public List<Message> getMessages(final UUID ticket) {

        return messagesBD.getOrDefault(String.valueOf(ticket), new ArrayList<>());
    }
}
