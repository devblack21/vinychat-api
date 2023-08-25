package com.devblack.vinychat.chat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class MessageListResponse implements Serializable {

    public MessageListResponse(final List<MessageDTO> messages) {
        this.messages = messages;
    }

    @JsonProperty("messages")
    List<MessageDTO> messages;


    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(final List<MessageDTO> messages) {
        this.messages = messages;
    }
}
