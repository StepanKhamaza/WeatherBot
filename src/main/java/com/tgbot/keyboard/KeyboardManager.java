package com.tgbot.keyboard;

import com.tgbot.dao.Request;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import java.util.HashMap;
import java.util.Map;

public class KeyboardManager {
    private final Map<String, Keyboard> keyboards = new HashMap<>();
    private Keyboard lastKeyboard = new MenuKeyboard();
    public KeyboardManager() {
        keyboards.put("Menu", new MenuKeyboard());
        keyboards.put("Settings", new SettingsKeyboard());
        keyboards.put("Notifications", new NotificationsKeyboard());
    }
    public ReplyKeyboardMarkup handle(Request request) {
        Message message = request.message();
        Keyboard currentKeyboard = keyboards.get(message.getText());
        if (currentKeyboard != null)
            lastKeyboard = currentKeyboard;

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setKeyboard(lastKeyboard.getKeyboard());

        return replyKeyboardMarkup;
    }
}