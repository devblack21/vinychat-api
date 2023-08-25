package com.devblack.vinychat.processor.adapter;

import com.devblack.vinychat.core.bot.BotService;
import com.devblack.vinychat.core.processor.InitializerSenderMessageProcessor;
import com.devblack.vinychat.core.processor.SenderMessageProcessor;
import com.devblack.vinychat.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@EnableAsync
public class InitializerSenderMessageProcessorAdapter implements InitializerSenderMessageProcessor {

    @Autowired
    private BotService botService;
    @Autowired
    private SenderMessageProcessor senderMessageProcessor;

    @Async
    @Override
    public Message sendAsync(final Message message) {
        final Message msg = botService.initializeMessage(message);
        init(msg).start();
        return msg;
    }

    private Thread init(final Message message) {
        return new Thread(() ->  {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
                senderMessageProcessor.send(message);
            } catch (final InterruptedException ignored) {}
        });
    }

}
