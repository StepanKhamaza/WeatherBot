package com.tgbot.command;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;

public interface Command {
    String getName();
    Response handle(Request request);
}