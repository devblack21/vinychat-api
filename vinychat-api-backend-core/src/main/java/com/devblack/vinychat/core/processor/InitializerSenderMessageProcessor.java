package com.devblack.vinychat.core.processor;

import com.devblack.vinychat.domain.Message;
import org.springframework.scheduling.annotation.Async;

public interface InitializerSenderMessageProcessor extends AsyncSenderMessageProcessor {

    @Async
    default Message send(final Message message) {
        return sendAsync(message);
    }
}
