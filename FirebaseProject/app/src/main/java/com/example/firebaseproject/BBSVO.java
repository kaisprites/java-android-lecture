package com.example.firebaseproject;

public class BBSVO {
    int num;
    String author;
    String content;
    String date;
    String title;

    public BBSVO() {
    }

    public BBSVO(String author, String content, String date, String title) {
        this.author = author;
        this.content = content;
        this.date = date;
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BBSVO{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
