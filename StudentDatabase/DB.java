package com.example.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    public DB (Context c) {
        super(c, "STUDENT", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = "CREATE TABLE students (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, USN TEXT, SEM INTEGER)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q = "DROP TABLE IF EXISTS students";
        db.execSQL(q);
        onCreate(db);
    }

    public void insert(String name, String usn, int sem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME", name);
        cv.put("USN", usn);
        cv.put("SEM", sem);
        db.insert("students", null, cv);
    }

    public String load() {
        String result = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM students", null);
        if (c.moveToFirst()) {
            do {
                String name = c.getString(1);
                String usn = c.getString(2);
                String sem = c.getString(3);
                result += name + "-" + usn + "-" + sem + "\n";
            } while(c.moveToNext());
        }
        return result;
    }

}
