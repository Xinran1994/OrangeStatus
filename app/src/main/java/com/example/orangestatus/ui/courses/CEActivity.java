package com.example.orangestatus.ui.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orangestatus.R;
import com.example.orangestatus.ui.courses.CECourses.CSE687;

public class CEActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce);
        setTitle("Computer Engineering");

        Button button687 = findViewById(R.id.button687);
        button687.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent687 = new Intent(CEActivity.this, CSE687.class);
                startActivity(intent687);
            }
        });
    }
}
