package com.example.calculator;

import android.content.Context;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class my_database extends SQLiteOpenHelper {

    public my_database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public my_database(MainActivity context) {
        super(context, "incest.db", null, 1);
    }

    // 数据库第一次被创建时调用该方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT, num1, sign1, num2, res)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void onOpen(SQLiteDatabase db) {
         super.onOpen(db);
    }
}
