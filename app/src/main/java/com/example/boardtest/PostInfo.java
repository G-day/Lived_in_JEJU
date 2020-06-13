package com.example.boardtest;

public class PostInfo {

    private String title;
    private String content;
    private String date;
    private String userName;

    public PostInfo(String title, String content, String date, String userName) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.userName = userName;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}




