package com.devblack.vinychat.core.processor;

import com.devblack.vinychat.domain.Message;

public interface HandshakeProcessor {

    Message invoke(final Message message);

}
