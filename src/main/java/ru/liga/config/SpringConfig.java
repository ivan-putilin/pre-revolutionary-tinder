package ru.liga.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.liga.telegram.PreRevolutionaryTinderBot;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class SpringConfig {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    @Bean
    public PreRevolutionaryTinderBot preRevolutionaryTinderBot(){

        PreRevolutionaryTinderBot preRevolutionaryTinderBot = new PreRevolutionaryTinderBot();
        preRevolutionaryTinderBot.setBotUserName(botUserName);
        preRevolutionaryTinderBot.setBotToken(botToken);
        preRevolutionaryTinderBot.setWebHookPath(webHookPath);

        return preRevolutionaryTinderBot;
    }
}
