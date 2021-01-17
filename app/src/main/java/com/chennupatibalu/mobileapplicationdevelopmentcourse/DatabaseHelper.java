package com.chennupatibalu.mobileapplicationdevelopmentcourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "StudentDetails_Table";
    public static final String col_1 = "ID";
    public static final String col_2 = "NAME";
    public static final String col_3 = "SURNAME";
    public static final String col_4 = "CGPA";
    public static final String col_5 = "DOB";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,CGPA REAL,DOB INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //Display data
    public Cursor getData()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return result;
    }

    //Data Insertion
    public boolean insertData(String name,String surname,float cgpa,int dob)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put(col_2,name);
        cv.put(col_3,surname);
        cv.put(col_4,cgpa);
        cv.put(col_5,dob);

        long result = db.insert(TABLE_NAME,null,cv);

        return result != -1;
    }

    //Data Updation
    public boolean updateData(String id,String name,String surname,float cgpa,int dob)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put(col_2,name);
        cv.put(col_3,surname);
        cv.put(col_4,cgpa);
        cv.put(col_5,dob);

        long result = db.update(TABLE_NAME,cv,"ID=?",new String[]{id});

        return result != -1;
    }

    //Data Deletion
    public Integer deleteData(String id)
    {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[]{id});
    }
}
