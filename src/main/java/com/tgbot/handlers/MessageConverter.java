package com.tgbot.handlers;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class MessageConverter implements Converter {
    @Override
    public Request convertMessageToRequest(Message message) {
        if (message.hasText())
            return new Request(message.getText());
        return new Request("");
    }

    @Override
    public Message convertResponseToMessage(Response response) {
        if (response.message() == null)
            response = new Response("");

        Message message = new Message();
        message.setText(response.message());
        return message;
    }
}