package com.example.androidcalendar;

public class ScheduleDTO {
    int id;
    String date;
    String time;
    String title;
    String content;
    Boolean alarm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAlarm() {
        return alarm;
    }

    public void setAlarm(Boolean alarm) {
        this.alarm = alarm;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", alarm=" + alarm +
                '}';
    }
}
