package com.example.orangestatus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orangestatus.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference users;

    EditText edtUsername, edtPassword, edtMail;
    Button btnSignUp, btnToSignIn, btnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJump = (Button)findViewById(R.id.jump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(s);
            }
        });

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtMail = (EditText) findViewById(R.id.edtMail);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                final User user = new User(edtUsername.getText().toString(),
                        edtPassword.getText().toString(),
                        edtMail.getText().toString());
                users.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(edtUsername.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this,"Please input the username!",Toast.LENGTH_SHORT).show();
                        }
                        else if(edtPassword.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this,"Please input the password!",Toast.LENGTH_SHORT).show();
                        }
                        else if(edtPassword.getText().toString().isEmpty()){
                            Toast.makeText(MainActivity.this,"Please input the E-mail address!",Toast.LENGTH_SHORT).show();
                        }
                        else if(dataSnapshot.child(user.getUsername()).exists())
                            Toast.makeText(MainActivity.this, "The Username is already exist!", Toast.LENGTH_SHORT).show();
                        else{
                            users.child(user.getUsername()).setValue(user);
                            Toast.makeText(MainActivity.this, "Success Register!", Toast.LENGTH_SHORT).show();
                            Intent s = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(s);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        btnToSignIn = (Button) findViewById(R.id.btnToSignIn);
        btnToSignIn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent s = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(s);
            }
        });
    }
}
