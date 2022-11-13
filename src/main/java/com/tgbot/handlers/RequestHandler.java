package com.tgbot.handlers;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;

public interface RequestHandler {
    Response handle(Request request);
}