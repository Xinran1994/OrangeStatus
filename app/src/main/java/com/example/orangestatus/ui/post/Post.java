package com.example.orangestatus.ui.post;

public class Post {
    private String title;
    private String content;

    public Post(){}

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
