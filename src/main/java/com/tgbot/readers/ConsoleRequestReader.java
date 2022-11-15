package com.tgbot.readers;

import com.tgbot.dao.Request;

import java.util.Scanner;

public class ConsoleRequestReader implements RequestReader {
    private final Scanner consoleScanner = new Scanner(System.in);
    @Override
    public Request read() {
        return new Request(consoleScanner.next());
    }
}