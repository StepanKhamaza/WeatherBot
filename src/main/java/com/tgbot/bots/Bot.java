package com.tgbot.bots;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import com.tgbot.handlers.MessageConverter;
import com.tgbot.handlers.RequestHandler;
import com.tgbot.handlers.SimpleRequestHandler;
import jdk.jshell.Snippet;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private final String botName;
    private final String botToken;
    private final RequestHandler requestHandler = new SimpleRequestHandler();
    private final MessageConverter messageConverter = new MessageConverter();

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
        Request request = messageConverter.convertMessageToRequest(update.getMessage());
        Response response = requestHandler.handle(request);
        Message message = messageConverter.convertResponseToMessage(response);
        SendMessage sendMessage = getSendMessage(update.getMessage().getChatId(), message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            mock(e);
        }
    }
    private void mock(Exception e) {
        // something is logged
    }
    private SendMessage getSendMessage(Long chatId, Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message.getText());
        return sendMessage;
    }
}