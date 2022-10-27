package com;

public class Main {
    public static void main(String[] args) {
        Bot bot = new Bot();

        while (bot.input()) {
            bot.output();
        }
    }
}