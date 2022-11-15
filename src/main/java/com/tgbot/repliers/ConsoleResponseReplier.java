package com.tgbot.repliers;

import com.tgbot.dao.Response;

public class ConsoleResponseReplier implements ResponseReplier {

    @Override
    public void reply(Response response) {
        System.out.println(response.message());
    }
}