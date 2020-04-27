package com.example.orangestatus.ui.post;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orangestatus.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddPostActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        setTitle("Add Your Comment");

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close );

        editTextTitle = findViewById(R.id.addPostTitle);
        editTextContent = findViewById(R.id.addPostContent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.right_top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_post:
                savePost();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void savePost(){
        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();

        if(title.trim().isEmpty() || content.trim().isEmpty()){
            Toast.makeText(this, "Please insert a title and content.", Toast.LENGTH_LONG).show();
            return;
        }
        CollectionReference PostListRef = FirebaseFirestore.getInstance().collection("PostList");
        PostListRef.add(new Post(title, content));
        Toast.makeText(this, "Comment added", Toast.LENGTH_SHORT).show();
    }
}
