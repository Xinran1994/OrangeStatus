package com.example.orangestatus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orangestatus.Model.Profiles;
import com.example.orangestatus.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference profiles;

    Button submit;
    EditText User_Name, User_Gender, User_Phone_Number, User_Address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        database = FirebaseDatabase.getInstance();
        profiles = database.getReference("Profiles");

        submit = (Button)findViewById(R.id.submit);
        User_Name = (EditText) findViewById(R.id.User_Name);
        User_Gender = (EditText) findViewById(R.id.User_Gender);
        User_Phone_Number = (EditText) findViewById(R.id.User_Phone_Number);
        User_Address = (EditText) findViewById(R.id.User_Address);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final Profiles info = new Profiles(User_Name.getText().toString(),
                                                   User_Gender.getText().toString(),
                                                   User_Phone_Number.getText().toString(),
                                                   User_Address.getText().toString());

                profiles.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        profiles.child(info.getUser_Name()).setValue(info);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                //submit_information(User_Name.getText().toString(), User_Gender.getText().toString(), User_Phone_Number.getText().toString(), User_Address.getText().toString());
                Toast.makeText(Profile.this, "Submit Successfully!!", Toast.LENGTH_SHORT).show();
                Intent s = new Intent(Profile.this, Show_Profile_Info.class);
                startActivity(s);
            }
        });
    }

    /*private void submit_information(String User_Name, String User_Gender, String User_Phone_Number, String User_Address) {
        profiles.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Profiles inforation = dataSnapshot.child(User_Name).getValue(Profiles.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/

}
