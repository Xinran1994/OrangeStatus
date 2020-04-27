package com.example.orangestatus.ui.checkin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.orangestatus.R;
import com.example.orangestatus.ui.checkin.buildings.bus_stop;
import com.example.orangestatus.ui.checkin.buildings.gym;
import com.example.orangestatus.ui.checkin.buildings.library;
import com.example.orangestatus.ui.checkin.buildings.restaurant;

public class building extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);
        Button b6 = (Button) findViewById(R.id.btm6);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(building.this, R.style.Theme_AppCompat_Light_Dialog_Alert);
                builder.setTitle("Hints");
                builder.setMessage("Cost one credit to view the busy level?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(building.this, library.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(building.this, building.class);
                        startActivity(i);
                    }
                });
                builder.show();
            }
        });
        Button b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(building.this, R.style.Theme_AppCompat_Light_Dialog_Alert);
                builder.setTitle("Hints");
                builder.setMessage("Cost one credit to view the busy level?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(building.this, restaurant.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(building.this, building.class);
                        startActivity(i);
                    }
                });
                builder.show();
            }
        });
        Button b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(building.this, R.style.Theme_AppCompat_Light_Dialog_Alert);
                builder.setTitle("Hints");
                builder.setMessage("Cost one credit to view the busy level? ");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(building.this, gym.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(building.this, building.class);
                        startActivity(i);
                    }
                });
                Button b9 = (Button) findViewById(R.id.button9);
                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(building.this, R.style.Theme_AppCompat_Light_Dialog_Alert);
                        builder.setTitle("Hints");
                        builder.setMessage("Cost one credit to view the busy level?");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(building.this, bus_stop.class);
                                startActivity(i);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(building.this, building.class);
                                startActivity(i);
                            }
                        });
                    }
                });
            }
        });
    }
}



