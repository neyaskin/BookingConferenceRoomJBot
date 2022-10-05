package org.example;

public class Event {
    private static final String[] eventParameters = {"Название мероприятия:", "Время начала:", "Продолжительность:", "Описание:"};
    private String Name;
    private String TimeStart;
    private String Duration;
    private String TimeEnd;
    private String Description;

    public Event(String userData) {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(String timeStart) {
        TimeStart = timeStart;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getTimeEnd() {
        return TimeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        TimeEnd = timeEnd;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
