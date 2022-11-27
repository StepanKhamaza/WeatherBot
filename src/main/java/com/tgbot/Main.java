package com.tgbot;

import com.tgbot.bots.ConsoleBot;
import com.tgbot.bots.TelegramBotStarter;

public class Main {
    public static void main(String[] args) {
        //ConsoleBot consoleBot = new ConsoleBot();
        //consoleBot.start();

        TelegramBotStarter telegramBotStarter = new TelegramBotStarter();
        telegramBotStarter.start();
    }
}