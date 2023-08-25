package com.devblack.vinychat.core.queue;

import com.devblack.vinychat.domain.Event;

public interface MessageQueueConsumer<T extends Event> {
    void sendMessageQueue(final T payload);
}
