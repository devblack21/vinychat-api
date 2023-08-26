package com.devblack.vinychat.core.bot;

import com.devblack.vinychat.domain.Message;

import java.util.UUID;

public interface BotService {
    Message initCall(final Message message, final UUID token);

    Message initializeMessage(final Message message);

}
