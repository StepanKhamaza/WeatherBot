package com.tgbot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.List;

public class SettingsKeyboard implements Keyboard {
    private final List<KeyboardRow> keyboard = new ArrayList<>();
    public SettingsKeyboard() {
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Notifications"));
        keyboardRow1.add(new KeyboardButton("Feedback"));
        keyboard.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Menu"));
        keyboard.add(keyboardRow2);
    }
    @Override
    public List<KeyboardRow> getKeyboard() {
        return keyboard;
    }
}