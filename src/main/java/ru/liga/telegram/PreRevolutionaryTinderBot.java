package ru.liga.telegram;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PreRevolutionaryTinderBot extends TelegramWebhookBot {

    String webHookPath;
    String botUserName;
    String botToken;

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {

        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            try {
                log.info("Received message: \"{}", update.getMessage().getText());
                execute(new SendMessage(Long.toString(chat_id), "Hi " + update.getMessage().getText()));
                log.info("Send message: \"Hi {}", update.getMessage().getText());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }
}
