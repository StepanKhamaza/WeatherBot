package com.tgbot.bots;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import com.tgbot.handlers.RequestHandler;
import com.tgbot.handlers.SimpleRequestHandler;
import com.tgbot.readers.BotRequestReader;
import com.tgbot.readers.TelegramBotRequestReader;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    private final String botName;
    private final String botToken;
    private final BotRequestReader reader = new TelegramBotRequestReader();
    private final RequestHandler requestHandler = new SimpleRequestHandler();

    public Bot(String botName, String botToken) {
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message message = update.getMessage();

                Request request = reader.read(message);
                Response response = requestHandler.handle(request);

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(message.getChatId());
                sendMessage.setText(response.message());
                execute(sendMessage);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}