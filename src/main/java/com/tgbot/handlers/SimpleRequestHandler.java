package com.tgbot.handlers;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;

public class SimpleRequestHandler implements RequestHandler {
    @Override
    public Response handle(Request request) {
        return new Response(request.someMessage());
    }
}