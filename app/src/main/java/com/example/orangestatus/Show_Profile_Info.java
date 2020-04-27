package com.example.orangestatus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.orangestatus.Model.Profiles;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Show_Profile_Info extends AppCompatActivity {
    TextView a,b,c,d;
    Button btn, edit;
    DatabaseReference reff;
    EditText User_Name, User_Gender, User_Phone_Number, User_Address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__profile__info);

        a = (TextView)findViewById(R.id.Show_Name);
        b = (TextView)findViewById(R.id.Show_Gender);
        c = (TextView)findViewById(R.id.Show_Phone_Number);
        d = (TextView)findViewById(R.id.Show_Address);
        btn = (Button)findViewById(R.id.btnload);
        edit = (Button)findViewById(R.id.edit);
        //String node = findViewById(R.id.User_Name).getContext().toString();

        User_Name = (EditText) findViewById(R.id.User_Name);
        User_Gender = (EditText) findViewById(R.id.User_Gender);
        User_Phone_Number = (EditText) findViewById(R.id.User_Phone_Number);
        User_Address = (EditText) findViewById(R.id.User_Address);

        edit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent s = new Intent(Show_Profile_Info.this,Profile.class);
                startActivity(s);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Profiles").child("sundongfang");
                reff.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.child("user_Name").getValue().toString();
                        String address = dataSnapshot.child("user_Address").getValue().toString();
                        String gender = dataSnapshot.child("user_Gender").getValue().toString();
                        String phone_number = dataSnapshot.child("user_Phone_Number").getValue().toString();
                        a.setText(name);
                        b.setText(gender);
                        c.setText(phone_number);
                        d.setText(address);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
