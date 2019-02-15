package com.example.aksha.collegeteachersdatabases2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText2,editText3,editText4;
    Button button,button2;
MyDataBase myDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        editText3=(EditText)findViewById(R.id.editText3);
        editText4=(EditText)findViewById(R.id.editText4);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);


    }
    public void addRecord(View view) {
        if (TextUtils.isEmpty(editText.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString()) || TextUtils.isEmpty(editText3.getText().toString()) || TextUtils.isEmpty(editText4.getText().toString())) {
            if (TextUtils.isEmpty(editText.getText().toString())) {
                editText.setError("Please Enter valid name");
            }
            if (TextUtils.isEmpty(editText2.getText().toString())) {
                editText2.setError("Please Enter valid age");
            }
            if (TextUtils.isEmpty(editText3.getText().toString())) {
                editText3.setError("Please Enter valid qualification");
            }
            if (TextUtils.isEmpty(editText4.getText().toString())) {
                editText4.setError("Please Enter valid experience in years");
            }
        } else {
            String name = editText.getText().toString();
            int age = Integer.parseInt(editText2.getText().toString());
            String qualification = editText3.getText().toString();
            int exp = Integer.parseInt(editText4.getText().toString());
            myDataBase = new MyDataBase(this);
            long id = myDataBase.addRecord(name, age, qualification, exp);
            if (id >= 0) {
                Toast.makeText(this, "Record Added Successfully!", Toast.LENGTH_LONG).show();
                editText.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");

            } else
                Toast.makeText(this, "Unsuccessful", Toast.LENGTH_LONG).show();
        }
    }
    public void displayRecord(View view)
    {
        myDataBase=new MyDataBase(this);
        String record=myDataBase.displayRecord();
        Toast.makeText(this,record,Toast.LENGTH_LONG).show();
    }
    public void updateRecord(View view)
    {
        Intent intent=new Intent(this,Update_activity.class);
        startActivity(intent);
    }
    public void deleteRecord(View view)
    {
        Intent intent=new Intent(this,delete_activity.class);
        startActivity(intent);
    }


}
