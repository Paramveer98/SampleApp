package com.example.mypractice.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "My_db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String Stud_db_query = "CREATE TABLE Student (stud_reg INTEGER PRIMARY KEY AUTOINCREMENT,stud_name TEXT,stud_class TEXT );";
        Log.e("table student", Stud_db_query);
        db.execSQL(Stud_db_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "Student");
        onCreate(sqLiteDatabase);


    }

    public void addStudentDetails(StudentDetails studentDetails) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();//store values which are passed for storing values in db
        values.put("stud_reg", studentDetails.getReg_id());
        values.put("stud_name", studentDetails.getName());
        values.put("stud_class", studentDetails.getStud_class());
//        Log.e("data insert", "data insert", values);

        db.insert("Student", null, values);  //database name, null, values of content values
        db.close();

    }

    public List<StudentDetails> getStudentDetails() {
        List<StudentDetails> studdet = new ArrayList<StudentDetails>();
        String fetch_query = "SELECT * FROM Student;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(fetch_query, null); //selection args for where clause



        if (cursor.moveToFirst()) {
            do {

                StudentDetails studentDetails = new StudentDetails();

                studentDetails.setReg_id(Integer.parseInt(cursor.getString(0))); //or cursor.getint
                studentDetails.setName(cursor.getString(1));
                studentDetails.setStud_class(cursor.getString(2));

                studdet.add(studentDetails);//in array list

            }
            while (cursor.moveToNext());

        }
        return studdet;


    }
}
