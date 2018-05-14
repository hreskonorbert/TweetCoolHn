package com.codecool.web.model;

public class Tweet {
    String content;
    String poster;

    public Tweet(String content, String poster) {
        this.content = content;
        this.poster = poster;
    }

    public String getContent() {
        return content;
    }

    public String getPoster() {
        return poster;
    }
}
