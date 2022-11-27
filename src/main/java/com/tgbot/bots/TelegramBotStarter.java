package com.tgbot.bots;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotStarter implements BotStarter {
    private final static Logger logger = Logger.getLogger(TelegramBotStarter.class);
    public TelegramBotStarter() {}
    @Override
    public void start() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot(System.getenv("BOT_NAME"), System.getenv("BOT_TOKEN")));
        } catch (TelegramApiException e) {
            logger.error("Bot startup error", e);
        }
    }
}