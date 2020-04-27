package com.example.orangestatus.ui.courses.CSCourses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.orangestatus.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class CIS657 extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference postListRef = db.collection("Courses");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cis657);
        setTitle("CIS657");


    }
}
