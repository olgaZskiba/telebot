package com.example.telegramBot.service;

import com.example.telegramBot.bot.TelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendBotMessageServiceRealisation implements SendBotMessageService {
    private final TelegramBot telegramBot;


    @Autowired
    public SendBotMessageServiceRealisation(TelegramBot telegramBot) {

        this.telegramBot = telegramBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            telegramBot.execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String chatId, ReplyKeyboard replyMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setReplyMarkup(replyMarkup);

        try {
            telegramBot.execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String chatId, String message, ReplyKeyboard replyMarkup) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(replyMarkup);

        try {
            telegramBot.execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMessage(String chatId, Integer message_id) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(chatId);
        deleteMessage.setMessageId(message_id);
        try {
            telegramBot.execute(deleteMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendPhoto(String chatId, String url) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(url);
        try {
            telegramBot.execute(sendPhoto);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




}
