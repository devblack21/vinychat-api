package com.devblack.vinychat.bot.adapter;

import com.devblack.vinychat.bot.properties.ChatBotMessageProperties;
import com.devblack.vinychat.bot.utils.BlockList;
import com.devblack.vinychat.core.bot.BotMediator;
import com.devblack.vinychat.domain.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotMediatorAdapter implements BotMediator {

    @Autowired
    private BlockList blockList;
    @Autowired
    private ChatBotMessageProperties properties;

    @Override
    public boolean mediate(final Message message) {

        final boolean isBlockList = blockList.contains(message.getMessageBody());
        final boolean isMessageMaxCaracteres = isMaxCaracteres(message.getMessageBody(),
                properties.getMediator().getMaxSize());

        final List<Boolean> predicates = List.of(isBlockList, isMessageMaxCaracteres);

        return !predicates.contains(Boolean.TRUE);
    }


    private boolean isMaxCaracteres(final String message, final int maxSize) {
        return StringUtils.length(message) > maxSize;
    }


}
