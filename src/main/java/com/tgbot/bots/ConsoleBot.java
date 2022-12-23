package com.tgbot.bots;

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

public class ConsoleBot implements BotStarter {
    private final RequestReader reader = new ConsoleRequestReader();
    private final ResponseReplier replier = new ConsoleResponseReplier();
    private final RequestHandler requestHandler = new SimpleRequestHandler();
    private final StopHandler stopHandler = new KeywordStopHandler("exit");
    @Override
    public void start() {
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