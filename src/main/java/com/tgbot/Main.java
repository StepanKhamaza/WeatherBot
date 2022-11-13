package com.tgbot;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import com.tgbot.handlers.KeywordStopHandler;
import com.tgbot.handlers.RequestHandler;
import com.tgbot.handlers.SimpleRequestHandler;
import com.tgbot.handlers.StopHandler;
import com.tgbot.readers.ConsoleRequestReader;
import com.tgbot.readers.RequestReader;
import com.tgbot.repliers.ConsoleResponseReplier;
import com.tgbot.repliers.ResponseReplier;

public class Main {
    public static void main(String[] args) {
        RequestReader reader = new ConsoleRequestReader();
        ResponseReplier replier = new ConsoleResponseReplier();
        RequestHandler requestHandler = new SimpleRequestHandler();
        StopHandler stopHandler = new KeywordStopHandler("exit");

        while(true) {
            Request request = reader.read();
            if (stopHandler.needStop(request)) {
                break;
            }

            Response response = requestHandler.handle(request);
            replier.reply(response);
        }
    }
}