package com.devblack.vinychat.processor.adapter;

import com.devblack.vinychat.core.bot.BotMediator;
import com.devblack.vinychat.core.processor.SenderMessageProcessor;
import com.devblack.vinychat.domain.Message;
import com.devblack.vinychat.processor.dto.MessageDTO;
import com.devblack.vinychat.processor.mapper.MessageDTOMapper;
import com.devblack.vinychat.repository.adapter.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.devblack.vinychat.core.routes.Routes.QUEUE_MESSAGE;

@Service
public class SenderMessageProcessorAdapter implements SenderMessageProcessor {

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private BotMediator botMediator;

    private final MessageRepository repository = new MessageRepository();

    @Override
    public Message send(final Message message) {

      if (botMediator.mediate(message)) {
          final String ticket = message.getTicketId();
          System.out.println(message.getTicketId()+" | "+message.getSenderUser()+": "+message.getMessageBody());

          template.convertAndSend(QUEUE_MESSAGE + ticket, MessageDTOMapper.INSTANCE.mapFrom(message));
          repository.addMessage(message);
      }

      return message;
    }



}
