package com.devblack.vinychat.processor.mapper;

import com.devblack.vinychat.processor.dto.MessageDTO;
import com.devblack.vinychat.domain.Message;

import java.util.List;
import java.util.stream.Collectors;

public class MessageDTOMapper {

    public final static MessageDTOMapper INSTANCE = new MessageDTOMapper();

    private MessageDTOMapper(){}
    public MessageDTO mapFrom(final Message source) {

        final MessageDTO target = new MessageDTO();

        target.setInitial(source.getInitial());
        target.setMessage(source.getMessageBody());
        target.setUsername(source.getSenderUser());
        target.setTicket(source.getTicketId());

        return target;
    }

    public List<MessageDTO> mapFrom(final List<Message> messages) {
        return messages.stream().map(this::mapFrom).collect(Collectors.toList());
    }

}
