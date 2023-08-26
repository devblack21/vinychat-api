package com.devblack.vinychat.bot.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Configuration
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("chatbot.message")
public class ChatBotMessageProperties {

    private Mediator mediator = new Mediator();

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Mediator {

        @NonNull
        private int maxSize = 50;

    }

}
