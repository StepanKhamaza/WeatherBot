package com.tgbot.command;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

public class CommandManager implements Command {
    private final Map<String, Command> commands = new HashMap<>();
    public CommandManager() {
        commands.put(CommandName.START.getName(), new StartCommand());
        commands.put(CommandName.INFO.getName(), new InfoCommand());
        commands.put(CommandName.HELP.getName(), new HelpCommand());
        commands.put(CommandName.SETTINGS.getName(), new SettingsCommand());
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