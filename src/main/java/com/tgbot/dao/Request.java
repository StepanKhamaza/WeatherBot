package com.tgbot.dao;

import org.telegram.telegrambots.meta.api.objects.Message;

public record Request(Message message) {
}