package com.tgbot.readers;

import com.tgbot.dao.Request;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface BotRequestReader {
    Request read(Message message);
}