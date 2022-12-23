package com.tgbot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import java.util.List;

public interface Keyboard {
    List<KeyboardRow> getKeyboard();
}
