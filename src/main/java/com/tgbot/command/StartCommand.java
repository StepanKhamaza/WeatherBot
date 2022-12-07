package com.tgbot.command;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.telegram.telegrambots.meta.api.objects.Message;

public class StartCommand implements Command {
    @Override
    public String getName() {
        return CommandName.START.getName();
    }
    @Override
    public Response handle(Request request) {
        Message message = request.message();
        message.setText(CommandName.START.getAnswer());

        return new Response(message);
    }
}