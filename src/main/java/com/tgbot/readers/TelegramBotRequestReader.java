package com.tgbot.readers;

import com.tgbot.dao.Request;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TelegramBotRequestReader implements BotRequestReader {

    @Override
    public Request read(Message message) {
        return new Request(message.getText());
    }
}