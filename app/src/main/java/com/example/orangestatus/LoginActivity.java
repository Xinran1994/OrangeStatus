package com.example.orangestatus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.orangestatus.Model.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference users;

    EditText edtUsername, edtPassword;
    Button btnSignIn, btnToSignUp, guest,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        edtUsername = (EditText) findViewById(R.id.edtUsername2);
        edtPassword = (EditText) findViewById(R.id.edtPassword2);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        guest = (Button)findViewById(R.id.Guest);
        admin = (Button)findViewById(R.id.Admin);

        btnSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                signIn(edtUsername.getText().toString(), edtPassword.getText().toString());
            }
        });

        btnToSignUp = (Button) findViewById(R.id.btnToSignUp);
        btnToSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent s = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(s);
            }
        });
        /*guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(LoginActivity.this, Post.class);
                startActivity(s);
            }
        });*/
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(LoginActivity.this, Course_Edit.class);
                startActivity(s);
            }
        });
    }

    private void signIn(final String username, final String password) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(username).exists()){
                    if(!username.isEmpty()){
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if(login.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this, "Success Login!", Toast.LENGTH_SHORT).show();
                            Intent s = new Intent(LoginActivity.this, Profile.class);
                            startActivity(s);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Password is Wrong!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(LoginActivity.this, "Username is empty", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(LoginActivity.this, "Username is not registered!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
