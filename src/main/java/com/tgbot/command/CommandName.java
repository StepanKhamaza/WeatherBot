package com.tgbot.command;

public enum CommandName {
    START("/start", "Enter the name of the city"),
    SETTINGS("/settings", "Select settings"),
    INFO("/info", "Your current settings"),
    HELP("/help", "Command /start to get started\n" +
            "after this command you need to enter the name of the city\n\n" +
            "Command /help for help\n\n" +
            "Command /info get information about the current setting\n\n" +
            "Command /settings configure weather output"),
    UNKNOWN("", "Unknown command. Please, try again");

    private String name;
    private String answer;

    CommandName(String name, String response) {
        this.name = name;
        this.answer = response;
    }

    public String getName() {
        return name;
    }

    public String getAnswer() {
        return answer;
    }
}
