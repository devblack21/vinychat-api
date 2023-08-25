package com.devblack.vinychat.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;

public class Message implements Serializable {

    public Message() {}

    private String ticketId;
    private String senderUser;
    private String messageBody;

    private transient Boolean initial = false;

    @JsonCreator
    public Message(final String ticket, final String username, final String message) {
        this.ticketId = ticket;
        this.senderUser = username;
        this.messageBody = message;
    }

    public void setInitial(final Boolean initial) {
        this.initial = initial;
    }

    public Boolean getInitial() {
        return initial;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public String getSenderUser() {
        return senderUser;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(final String ticket) {
        this.ticketId = ticket;
    }

    public void setMessageBody(final String message) {
        this.messageBody = message;
    }

    public void setSenderUser(final String username) {
        this.senderUser = username;
    }


}