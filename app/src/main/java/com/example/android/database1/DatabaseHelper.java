package com.example.android.database1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BAPU1 on 01/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="student.db";
    public static final String TABLE_NAME="student_table";
    public static final String col_1="ID";
    public static final String col_2="NAME";
    public static final String col_3="SURNAME";
    public static final String col_4="MARKS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_String = "CREATE TABLE " + TABLE_NAME + "(" + col_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + col_2 +
                " TEXT," + col_3 + " TEXT," + col_4 +"INTEGER NOT NULL"+ ")";
        db.execSQL(SQL_String);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+DATABASE_NAME);
        onCreate(db);

    }
    public boolean insertData(String name,String surname,String marks)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(col_2,name);
        values.put(col_3,surname);
        values.put(col_4,marks);
        long newRowId= db.insert(TABLE_NAME,null,values);
        db.close();
        if(newRowId==-1)
        {
            return false;
        }
        else{
            return true;
        }
    }
}
