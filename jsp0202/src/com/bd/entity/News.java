package com.bd.entity;

public class News {
    private int newsID;
    private String title;
    private String content;

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
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

    public News() {
    }

    public News(int newsID, String title, String content) {
        this.newsID = newsID;
        this.title = title;
        this.content = content;
    }
}
