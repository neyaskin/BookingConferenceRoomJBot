package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SupportTomTITBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Support TomTIT";
    }

    @Override
    public String getBotToken() {
        return System.getenv("SUPPORTTOMTITBOTTOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText() &&
                update.getMessage().getText().startsWith("Добавить мероприятие в конференц зал")) {
            SendMessage message = new SendMessage();
            message.setChatId(update.getMessage().getChatId().toString());

            // Находим индекс нужных параметров (Ищем где они начинаются)
            int eventNameIndex = update.getMessage().getText().indexOf("Название мероприятия:");
            int eventTimeIndex = update.getMessage().getText().indexOf("Время начала:");
            int eventDurationIndex = update.getMessage().getText().indexOf("Продолжительность:");
            int eventDescriptionIndex = update.getMessage().getText().indexOf("Описание:");

            if (eventNameIndex != -1 && eventTimeIndex != -1 && eventDurationIndex != -1 && eventDescriptionIndex != -1) {
                // Получаем подстроки в диапазоне от одного параметра до другого, используя индексы которые нашли до этого
                String eventNameNoFormat = update.getMessage().getText().substring(eventNameIndex, eventTimeIndex).trim();
                String eventTimeNoFormat = update.getMessage().getText().substring(eventTimeIndex, eventDurationIndex).trim();
                String eventDurationNoFormat = update.getMessage().getText().substring(eventDurationIndex, eventDescriptionIndex).trim();
                String eventDescriptionNoFormat = update.getMessage().getText().substring(eventDescriptionIndex, update.getMessage().getText().length() - 1).trim();

                // Получаем подстроки после названия параметров мероприятия
                String eventName = eventNameNoFormat.substring(eventNameNoFormat.indexOf(':') + 1).trim();
                String eventTime = eventTimeNoFormat.substring(eventTimeNoFormat.indexOf(':') + 1).trim();
                String eventDuration = eventDurationNoFormat.substring(eventDurationNoFormat.indexOf(':') + 1).trim();
                String eventDescription = eventDescriptionNoFormat.substring(eventDescriptionNoFormat.indexOf(':') + 1).trim();
                
//                message.setText(eventName + "" + eventTime + "" + eventDuration + "" + eventDescription);
                message.setText(eventName + "\n" + eventTime + "\n" + eventDuration + "\n" + eventDescription);


//                Event createNewEvent = new Event(eventName, eventTime, eventDuration, eventDescription);
            } else {
                message.setText("Неверный формат");
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
