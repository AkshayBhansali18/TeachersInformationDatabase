package com.example.aksha.collegeteachersdatabases2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

 class MyDataBase {
    InnerDatabaseClass innerDatabaseClass;
    public MyDataBase(Context context)
    {
        innerDatabaseClass=new InnerDatabaseClass(context);
    }
    public long addRecord(String name,int age,String qualification,int experience)
    {
        SQLiteDatabase db=innerDatabaseClass.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(innerDatabaseClass.name,name);
        contentValues.put(innerDatabaseClass.age,age);
        contentValues.put(innerDatabaseClass.qualification,qualification);
        contentValues.put(innerDatabaseClass.experience,experience);
        long id=db.insert(innerDatabaseClass.TABLE_NAME,null,contentValues);
        return id;

    }
    public String displayRecord()
    {
        SQLiteDatabase db=innerDatabaseClass.getWritableDatabase();
String columns[]={innerDatabaseClass.uid,innerDatabaseClass.name,innerDatabaseClass.age,innerDatabaseClass.qualification,innerDatabaseClass.experience};

        Cursor cursor=db.query(innerDatabaseClass.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer sb=new StringBuffer();
        while(cursor.moveToNext())
        {
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            int age=cursor.getInt(2);
            String qualification=cursor.getString(3);
            int experience=cursor.getInt(4);
            sb.append(id+" "+name+" "+age+" "+qualification+" "+experience+"\n");

        }
        return sb.toString();
    }
    public long deleteRecord(String data)
    {
        SQLiteDatabase db=innerDatabaseClass.getWritableDatabase();
       long value= db.delete(innerDatabaseClass.TABLE_NAME,innerDatabaseClass.name+"='"+data+"'",null);
        return value;

    }
     public long updateRecord(String oldname,String newname,int age,String qualification,int experience)
     {
         SQLiteDatabase db=innerDatabaseClass.getWritableDatabase();
         ContentValues contentValues=new ContentValues();
         contentValues.put(innerDatabaseClass.name,newname);
         contentValues.put(innerDatabaseClass.age,age);
         contentValues.put(innerDatabaseClass.qualification,qualification);
         contentValues.put(innerDatabaseClass.experience,experience);
         long update=db.update(innerDatabaseClass.TABLE_NAME,contentValues,innerDatabaseClass.name+"='"+oldname+"'",null);
         return update;
     }
    private static class InnerDatabaseClass extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "Database.db";
        private static final int DATABASE_VERSION = 1;
        private static final String name="name";
        private static final String age="age";
        private static final String qualification="qualification";
        private static final String experience="experience";
        private static final String TABLE_NAME="My_Table";
        private static final String uid="_id";
        Context context;
        public InnerDatabaseClass(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL("CREATE TABLE "+TABLE_NAME+" (_id integer primary key autoincrement, name varchar(250),age integer, qualification varchar(250),experience integer); ");
            } catch (SQLException e) {
                new MyMessage().myMessage(context,e.toString());
            }


        }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        } catch (SQLException e) {
            new MyMessage().myMessage(context,e.toString());
        }

    }
}
}
