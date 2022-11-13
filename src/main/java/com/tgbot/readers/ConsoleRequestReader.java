package com.tgbot.readers;

import com.tgbot.dao.Request;

import java.util.Scanner;

public class ConsoleRequestReader implements RequestReader {
    @Override
    public Request read() {
        Scanner in = new Scanner(System.in);

        return new Request(in.next());
    }
}