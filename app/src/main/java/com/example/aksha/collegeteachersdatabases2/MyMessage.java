package com.example.aksha.collegeteachersdatabases2;

import android.content.Context;
import android.widget.Toast;

public class MyMessage {
   public void myMessage(Context context,String data)
   {
       Toast.makeText(context,data,Toast.LENGTH_LONG).show();
   }
}
