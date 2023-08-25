package com.devblack.vinychat.processor.dto;

import com.devblack.vinychat.domain.Event;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDTO extends Event {

    public MessageDTO() {}

    @JsonProperty("ticket")
    private String ticket;
    @JsonProperty("username")
    private String senderUser;
    @JsonProperty("message")
    private String message;

    private transient Boolean initial = false;

    @JsonCreator
    public MessageDTO(final String ticket, String username, String message) {
        this.ticket = ticket;
        this.senderUser = username;
        this.message = message;
    }

    public void setInitial(final Boolean initial) {
        this.initial = initial;
    }

    public Boolean getInitial() {
        return initial;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderUser() {
        return senderUser;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(final String ticket) {
        this.ticket = ticket;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setUsername(final String username) {
        this.senderUser = username;
    }

    @Override
    public String toString() {
        return "Message{" +
                "ticket='" + ticket + '\'' +
                ", username='" + senderUser + '\'' +
                ", message='" + message + '\'' +
                ", initial=" + initial +
                '}';
    }

}