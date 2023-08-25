package com.devblack.vinychat.client.mapper;

import com.devblack.vinychat.client.dto.MessageDTO;
import com.devblack.vinychat.domain.Message;

public class MessageMapper {

    public final static MessageMapper INSTANCE = new MessageMapper();

    private MessageMapper(){}
    public Message mapFrom(final MessageDTO source) {

        final Message target = new Message();

        target.setInitial(source.getInitial());
        target.setMessageBody(source.getMessage());
        target.setSenderUser(source.getSenderUser());
        target.setTicketId(source.getTicket());

        return target;
    }

}
