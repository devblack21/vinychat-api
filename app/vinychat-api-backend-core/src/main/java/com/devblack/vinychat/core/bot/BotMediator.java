package com.devblack.vinychat.core.bot;

import com.devblack.vinychat.domain.Message;

public interface BotMediator {

    boolean mediate(final Message message);

}
