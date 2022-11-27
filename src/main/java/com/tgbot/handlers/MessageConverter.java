package com.tgbot.handlers;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageConverter implements Converter {
    @Override
    public Request convertMessageToRequest(Message message) {
        if (message.hasText())
            return new Request(message);
        return new Request(new Message());
    }

    @Override
    public SendMessage convertResponseToMessage(Response response) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(response.message().getChatId());
        sendMessage.setText(response.message().getText());

        return sendMessage;
    }
}