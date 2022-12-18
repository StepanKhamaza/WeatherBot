package com.tgbot.handlers;

import com.tgbot.dao.Request;
import com.tgbot.dao.Response;
import com.tgbot.data.APIRequest;
import com.tgbot.keyboard.answer.Answers;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.HashMap;
import java.util.Map;

public class SimpleRequestHandler implements RequestHandler {
    private final Map<String, Answers> answers = new HashMap<>();
    private String lastMessage = "";
    public SimpleRequestHandler() {
        answers.put("Menu", Answers.MENU);
        answers.put("Weather", Answers.MENU);
        answers.put("Settings", Answers.SETTINGS);
        answers.put("Notifications", Answers.NOTIFICATIONS);
        answers.put("Info", Answers.INFO);
        answers.put("City", Answers.CITY);
        answers.put("Feedback", Answers.FEEDBACK);
    }
    @Override
    public Response handle(Request request) {
        Message message = request.message();
        Response response = null;

        Answers answer = answers.get(message.getText());
        if (answer == null) {
            answer = Answers.UNKNOWN;
            if (lastMessage.equals("Weather") || lastMessage.equals("City") || lastMessage.equals("Menu"))
                response = new APIRequest().handle(request);
            if (lastMessage.equals("Feedback"))
                answer = Answers.THANKS;
        } else
            lastMessage = message.getText();

        if (response == null) {
            message.setText(answer.getAnswer());
            return new Response(message);
        }

        return response;
    }
}