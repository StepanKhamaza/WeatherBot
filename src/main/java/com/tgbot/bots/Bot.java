package com.tgbot.bots;

import com.tgbot.command.Command;
import com.tgbot.command.CommandList;
import com.tgbot.command.CommandManager;
import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import com.tgbot.handlers.MessageConverter;
import com.tgbot.handlers.RequestHandler;
import com.tgbot.handlers.SimpleRequestHandler;
import com.tgbot.keyboard.KeyboardManager;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class Bot extends TelegramLongPollingBot {
    private final static Logger logger = Logger.getLogger(Bot.class);
    private final String botName;
    private final String botToken;
    private final RequestHandler requestHandler = new SimpleRequestHandler();
    private final MessageConverter messageConverter = new MessageConverter();
    private final Command commandManager = new CommandManager(new CommandList().getCommands());
    private final KeyboardManager keyboardManager = new KeyboardManager();
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
        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardManager.handle(request);
        Response response = commandManager.handle(request);
        if (response == null)
            response = requestHandler.handle(request);

        SendMessage sendMessage = messageConverter.convertResponseToMessage(response);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            logger.error("Error sending message", e);
        }
    }
}