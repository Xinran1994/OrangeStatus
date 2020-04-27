package com.example.orangestatus.ui.market;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class items extends AppCompatActivity {

    String name;
    private int imageId;

    public items(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
