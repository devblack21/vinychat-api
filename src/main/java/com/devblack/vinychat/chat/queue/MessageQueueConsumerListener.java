package com.devblack.vinychat.chat.queue;

import com.devblack.vinychat.chat.dto.MessageDTO;
import com.devblack.vinychat.chat.mapper.MessageMapper;
import com.devblack.vinychat.core.processor.SenderMessageProcessor;
import com.devblack.vinychat.core.queue.MessageQueueConsumer;
import com.devblack.vinychat.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import static com.devblack.vinychat.core.routes.Routes.MESSAGE_ROUTE_MAPPING;
import static com.devblack.vinychat.core.routes.Routes.SEND_MESSAGE;

@Controller
public class MessageQueueConsumerListener implements MessageQueueConsumer<MessageDTO> {

    @Autowired
    private SenderMessageProcessor senderMessageProcessor;

    @MessageMapping(MESSAGE_ROUTE_MAPPING + SEND_MESSAGE)
    public void sendMessageQueue(final @Payload MessageDTO requestBody) {
        final Message messageDomain = MessageMapper.INSTANCE.mapFrom(requestBody);
        senderMessageProcessor.send(messageDomain);
    }

}