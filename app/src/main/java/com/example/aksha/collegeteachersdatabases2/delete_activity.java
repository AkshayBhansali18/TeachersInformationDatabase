package com.example.aksha.collegeteachersdatabases2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete_activity extends AppCompatActivity {
    Button delete_button;
    EditText editText5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_activity);
        delete_button=(Button)findViewById(R.id.delete_button);
        editText5=(EditText)findViewById(R.id.editText5);


    }
    public void deleteRecord(View view)
    {
        if(TextUtils.isEmpty(editText5.getText().toString()))
        {
            editText5.setError("Please enter a valid name");
        }
       MyDataBase myDataBase=new MyDataBase(this);
       String name=editText5.getText().toString();
     long delete=  myDataBase.deleteRecord(name);
     if(delete>0) {
         Toast.makeText(this, "Delete Successful", Toast.LENGTH_LONG).show();
         editText5.setText("");
     }
     else
         Toast.makeText(this,"Record Does Not Exist",Toast.LENGTH_LONG).show();


    }
}
