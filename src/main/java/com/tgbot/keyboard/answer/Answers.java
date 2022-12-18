package com.tgbot.keyboard.answer;

public enum Answers {
    CITY("Enter city."),
    MENU("Here you can start over. Enter city"),
    SETTINGS("Here you can set up notifications or leave feedback."),
    NOTIFICATIONS("Choose the type of notification"),
    INFO("I remember your choice"),
    FEEDBACK("Here you can leave a feedback"),
    THANKS("Thank you, I remember your comment :)"),
    UNKNOWN("I didn't understand your message, please try again");
    private String answer;
    Answers(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return this.answer;
    }
}