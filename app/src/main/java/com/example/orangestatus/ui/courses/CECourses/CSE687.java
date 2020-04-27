package com.example.orangestatus.ui.courses.CECourses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orangestatus.R;
import com.example.orangestatus.ui.post.AddPostActivity;
import com.example.orangestatus.ui.post.PostList;

public class CSE687 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse687);
        setTitle("CSE687");

        Button viewPost = findViewById(R.id.viewComment);
        viewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewPosts = new Intent(CSE687.this, PostList.class);
                startActivity(viewPosts);
            }
        });
    }
}
