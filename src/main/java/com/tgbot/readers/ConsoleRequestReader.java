package com.tgbot.readers;

import com.tgbot.dao.Request;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Scanner;

public class ConsoleRequestReader implements RequestReader {
    private final Scanner consoleScanner = new Scanner(System.in);
    @Override
    public Request read() {
        Message message = new Message();
        message.setText(consoleScanner.next());

        return new Request(message);
    }
}