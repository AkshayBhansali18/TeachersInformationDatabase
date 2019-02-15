package com.example.aksha.collegeteachersdatabases2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_activity extends AppCompatActivity {
    EditText old_name,new_name,new_age,new_qualifications,new_expereince;
    Button update_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activity);
        old_name=(EditText)findViewById(R.id.old_name);
        new_name=(EditText)findViewById(R.id.new_name);
        new_age=(EditText)findViewById(R.id.new_age);
        new_qualifications=(EditText)findViewById(R.id.new_qualifications);
        new_expereince=(EditText)findViewById(R.id.new_experience);

    }
    public void update_record(View view) {
        if (TextUtils.isEmpty(old_name.getText().toString()) || TextUtils.isEmpty(new_name.getText().toString()) || TextUtils.isEmpty(new_age.getText().toString()) || TextUtils.isEmpty(new_qualifications.getText().toString()) || TextUtils.isEmpty(new_expereince.getText().toString())) {
            if (TextUtils.isEmpty(old_name.getText().toString())) {
                old_name.setError("Please enter a valid name");
            }
            if (TextUtils.isEmpty(new_name.getText().toString())) {
                new_name.setError("Please enter a valid name");
            }
            if (TextUtils.isEmpty(new_age.getText().toString())) {
                new_age.setError("Please Enter valid age");
            }
            if (TextUtils.isEmpty(new_qualifications.getText().toString())) {
                new_expereince.setError("Please Enter valid Experience");
            }
            if (TextUtils.isEmpty(new_qualifications.getText().toString())) {
                new_qualifications.setError("Please Enter valid qualifications");
            }
        } else {
            String oldName = old_name.getText().toString();
            String newName = new_name.getText().toString();
            int age = Integer.parseInt(new_age.getText().toString());
            String qualifications = new_qualifications.getText().toString();
            int experience = Integer.parseInt(new_expereince.getText().toString());
            MyDataBase myDataBase = new MyDataBase(this);
            long record = myDataBase.updateRecord(oldName, newName, age, qualifications, experience);
            if (record > 0)
                Toast.makeText(this, "Record Updated Successfully!", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Record Does Not Exist", Toast.LENGTH_LONG).show();
        }
    }
}
