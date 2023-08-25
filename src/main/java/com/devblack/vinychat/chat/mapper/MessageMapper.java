package com.devblack.vinychat.chat.mapper;

import com.devblack.vinychat.chat.dto.MessageDTO;
import com.devblack.vinychat.domain.Message;

public class MessageMapper {

    public final static MessageMapper INSTANCE = new MessageMapper();

    private MessageMapper(){}
    public Message mapFrom(final MessageDTO source) {

        final Message target = new Message();

        target.setInitial(source.getInitial());
        target.setMessageBody(source.getMessage());
        target.setSenderUser(source.getUsername());
        target.setTicketId(source.getTicket());

        return target;
    }

}
