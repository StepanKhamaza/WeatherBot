package com.tgbot.handlers;

import com.tgbot.dao.Request;

public record KeywordStopHandler(String stopCommand) implements StopHandler {
    @Override
    public boolean needStop(Request request) {
        return request.message().getText().equals(stopCommand());
    }
}