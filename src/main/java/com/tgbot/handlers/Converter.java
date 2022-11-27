package com.tgbot.handlers;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Converter {
    Request convertMessageToRequest(Message message);
    SendMessage convertResponseToMessage(Response response);
}