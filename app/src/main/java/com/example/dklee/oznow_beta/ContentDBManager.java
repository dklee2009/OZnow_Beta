package com.example.dklee.oznow_beta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kyounghee on 2015-08-14.
 */
public class ContentDBManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Oznow.db";
    public static final String TABLE_NAME="OZnow";

    public ContentDBManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    /**
     * 처음 db 생성시 호출
     * create table 한다.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE "+TABLE_NAME
                +"(_id integer primary key autoincrement, content text, kind text, bookmark text, c_name text, c_color text)";
        db.execSQL(sql);
    }
    /**
     * DB 버전 변경될 때 호출
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="drop table if exists "+TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }
}
