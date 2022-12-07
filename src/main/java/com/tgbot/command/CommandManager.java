package com.tgbot.command;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommandManager implements Command {
    private Map<String, Command> commands = new HashMap<>();
    public CommandManager(List<Command> list) {
        commands = list.stream()
                .collect(Collectors.toMap(Command::getName, Function.identity()));
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Response handle(Request request) {
        Message message = request.message();
        Command currentCommand = commands.get(message.getText());
        if (currentCommand == null) {
            if (message.getText().charAt(0) == '/') {
                message.setText(CommandName.UNKNOWN.getAnswer());
                return new Response(message);
            }
            return null;
        }

        return currentCommand.handle(request);
    }
}