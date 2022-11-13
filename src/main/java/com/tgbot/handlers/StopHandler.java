package com.tgbot.handlers;

import com.tgbot.dao.Request;

public interface StopHandler {
    boolean needStop(Request request);
}