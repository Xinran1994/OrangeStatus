package com.example.orangestatus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Course_Edit extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText edit_course_name, edit_time, edit_location, edit_course_id;
    Button btnAddData, btnviewAll, btnviewUpdate, btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__edit);

        mydb = new DatabaseHelper(this);

        edit_course_name = (EditText)findViewById(R.id.Edit_Course_Name);
        edit_time = (EditText)findViewById(R.id.Edit_Time);
        edit_location = (EditText)findViewById(R.id.Edit_Location);
        edit_course_id = (EditText)findViewById(R.id.Edit_ID);
        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.view_all);
        btnviewUpdate = (Button)findViewById(R.id.update);
        btnDelete = (Button)findViewById(R.id.delete);
        AddData();
        viewAll();
        UpdateData();
        Delete();
    }

    public void Delete() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = mydb.deleteData(edit_course_id.getText().toString());
                if(deletedRows > 0){
                    Toast.makeText(Course_Edit.this, "Data Deleted!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Course_Edit.this, "Data not Deleted!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void UpdateData(){
        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = mydb.updateData(edit_course_id.getText().toString(),
                                                   edit_course_name.getText().toString(),
                                                   edit_time.getText().toString(),
                                                   edit_location.getText().toString());
                if(isUpdate == true){
                    Toast.makeText(Course_Edit.this, "Data Update!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Course_Edit.this, "Data not Update!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.insertData(edit_course_id.getText().toString(),
                                                     edit_course_name.getText().toString(),
                                                     edit_time.getText().toString(),
                                                     edit_location.getText().toString());
                if (isInserted == true){
                    Toast.makeText(Course_Edit.this, "Data Inserted!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Course_Edit.this, "Data not Inserted!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void viewAll(){
        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getAllData();
                if(res.getCount() == 0){
                    showMessage("Error", "Nothind found!");
                    //show message
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID: "+res.getString(0) + "\n");
                    buffer.append("Course_Name: "+res.getString(1) + "\n");
                    buffer.append("Time: "+res.getString(2) + "\n");
                    buffer.append("Location: "+res.getString(3) + "\n\n");
                }
                showMessage("Data",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
