package com.devblack.vinychat.core.processor;

import com.devblack.vinychat.domain.Message;

public interface AsyncSenderMessageProcessor {

    Message sendAsync(final Message message);


}
