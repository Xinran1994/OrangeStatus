package com.example.orangestatus.ui.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orangestatus.R;
import com.example.orangestatus.ui.courses.CECourses.CSE687;
import com.example.orangestatus.ui.courses.CSCourses.CIS657;

public class CSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Computer Science");
        setContentView(R.layout.activity_cs);

        Button button657 = findViewById(R.id.button657);
        button657.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent657 = new Intent(CSActivity.this, CIS657.class);
                startActivity(intent657);
            }
        });
    }
}
