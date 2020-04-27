package com.example.orangestatus.Model;

public class Posts {
    private String text;

    public Posts(){

    }

    public Posts(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
