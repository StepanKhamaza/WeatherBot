package com.tgbot.command;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;

public interface Command {
    Response handle(Request request);
}