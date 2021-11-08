package com.example.cis_692_final_project.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "weightEntryDB";
    private static final String TABLE_ENTRIES = "entries";
    private static final String ID = "id";
    private static final String WEIGHT_ENTRY_INPUT = "weight_entry_input";
    private static final String WEIGHT_ENTRY_INPUT_DATE = "weight_entry_input_date";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String sqlCreate = "create table " + TABLE_ENTRIES + "( " + ID;
        sqlCreate += " integer primary key autoincrement, " + WEIGHT_ENTRY_INPUT;
        sqlCreate += " text, " + WEIGHT_ENTRY_INPUT_DATE + " text )";

        db.execSQL(sqlCreate);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_ENTRIES);
        onCreate(db);
    }

    public void insert(NewEntry newEntry) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + TABLE_ENTRIES;
        sqlInsert += " values( null, '" + newEntry.getInputWeight();
        sqlInsert += "', '" + newEntry.getInputDate() + "' )";

        db.execSQL(sqlInsert);
        db.close();
    }

    public void deleteById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "delete from " + TABLE_ENTRIES;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL(sqlDelete);
        db.close();
    }

    public ArrayList<NewEntry> selectAll() {
        String sqlQuery = "select * from " + TABLE_ENTRIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<NewEntry> entries = new ArrayList<NewEntry>();
        while (cursor.moveToNext()) {
            NewEntry currentEntry
                    = new NewEntry(Integer.parseInt(cursor.getString(0)),
                    cursor.getFloat(1), cursor.getString(2));
            entries.add(currentEntry);
        }

        db.close();
        return entries;
    }

    public NewEntry selectById(int id) {
        String sqlQuery = "select * from " + TABLE_ENTRIES;
        sqlQuery += " where " + ID + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        NewEntry entry = null;
        if (cursor.moveToFirst())
            entry = new NewEntry(Integer.parseInt(cursor.getString(0)),
                    cursor.getFloat(1), cursor.getString(2));
        return entry;
    }

    public String getAverage() {
        String sqlQuery = "select avg(" + WEIGHT_ENTRY_INPUT + ") from " + TABLE_ENTRIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        int avg = 0;

        if (cursor.moveToFirst()) {
            avg = (int) Float.parseFloat(cursor.getString(0));
        }

        db.close();

        return String.valueOf(avg);
    }

    public String getLastEntry() {
        System.out.println("LOGDEBUG #1");
        String sqlQuery = "select * from " + TABLE_ENTRIES + " order by " + WEIGHT_ENTRY_INPUT;
        sqlQuery += " desc limit 1";

        System.out.println("LOGDEBUG #2");

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);
        System.out.println("LOGDEBUG #3");

        int lastEntry = 0;

        if (cursor.moveToFirst()) {
            lastEntry = (int) Float.parseFloat(cursor.getString(0));
        }

        System.out.println("LOGDEBUG #4: " + lastEntry);

        db.close();

        return String.valueOf(lastEntry);
    }
}
