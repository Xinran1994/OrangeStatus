package com.example.orangestatus.ui.courses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orangestatus.R;

public class EECSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("EECS");
        setContentView(R.layout.activity_eecs);

        Button buttonCS = findViewById(R.id.buttonCS);
        buttonCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCS = new Intent(EECSActivity.this,CSActivity.class);
                startActivity(intentCS);
            }
        });

        Button buttonEE = findViewById(R.id.buttonEE);
        buttonEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEE = new Intent(EECSActivity.this,EEActivity.class);
                startActivity(intentEE);
            }
        });

        Button buttonCE = findViewById(R.id.buttonCE);
        buttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCE = new Intent(EECSActivity.this,CEActivity.class);
                startActivity(intentCE);
            }
        });
    }
}
