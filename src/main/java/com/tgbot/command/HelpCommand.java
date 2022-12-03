package com.tgbot.command;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.telegram.telegrambots.meta.api.objects.Message;

public class HelpCommand implements Command {
    @Override
    public Response handle(Request request) {
        Message message = request.message();
        message.setText(CommandName.HELP.getAnswer());

        return new Response(message);
    }
}