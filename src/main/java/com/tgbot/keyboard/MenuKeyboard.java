package com.tgbot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.ArrayList;
import java.util.List;

public class MenuKeyboard implements Keyboard {
    private final List<KeyboardRow> keyboard = new ArrayList<>();
    public MenuKeyboard() {
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("City"));
        keyboardRow1.add(new KeyboardButton("Weather"));
        keyboard.add(keyboardRow1);

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Settings"));
        keyboard.add(keyboardRow2);
    }
    @Override
    public List<KeyboardRow> getKeyboard() {
        return keyboard;
    }
}