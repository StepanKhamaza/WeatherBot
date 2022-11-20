package com.tgbot;

import com.tgbot.bots.ConsoleBot;
import com.tgbot.bots.TelegramBot;

public class Main {
    public static void main(String[] args) {
        //ConsoleBot consoleBot = new ConsoleBot();
        //consoleBot.start();

        TelegramBot telegramBot = new TelegramBot();
        telegramBot.start();
    }
}