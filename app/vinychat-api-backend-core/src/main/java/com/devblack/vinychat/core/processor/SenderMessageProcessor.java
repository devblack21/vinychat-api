package com.devblack.vinychat.core.processor;

import com.devblack.vinychat.domain.Message;

public interface SenderMessageProcessor {

    Message send(final Message message);


}
