package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botApi = new TelegramBotsApi(DefaultBotSession.class);
            botApi.registerBot(new SupportTomTITBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}

//    Добавить мероприятие в конференц зал
//        Название мероприятия: Test event