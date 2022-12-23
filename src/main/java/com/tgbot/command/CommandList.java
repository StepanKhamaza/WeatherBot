package com.tgbot.command;

import java.util.ArrayList;
import java.util.List;

public class CommandList {
    private final List<Command> commands = new ArrayList<>();
    public CommandList() {
        commands.add(new StartCommand());
        commands.add(new HelpCommand());
        commands.add(new SettingsCommand());
        commands.add(new InfoCommand());
    }

    public List<Command> getCommands() {
        return commands;
    }
}
