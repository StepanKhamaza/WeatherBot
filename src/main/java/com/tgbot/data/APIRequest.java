package com.tgbot.data;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.telegram.telegrambots.meta.api.objects.Message;
import java.io.IOException;

public class APIRequest {
    private final static Logger logger = Logger.getLogger(APIRequest.class);
    public APIRequest() {}

    public Response handle(Request request) {
        Message message = request.message();
        String result = null;
        try {
            String doc = Jsoup.connect(String.format(
                            System.getenv().get("REQUEST_DATA"), request.message().getText()))
                            .ignoreContentType(true).execute().body();
            result = new JsonParser().getData(doc);
        } catch (IOException e) {
            logger.error("Failed to request data", e);
        }
        if (result != null) {
            message.setText(result);
            return new Response(message);
        }
        return null;
    }
}