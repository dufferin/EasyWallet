package com.example.easywallet.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Dell on 10/12/2560.
 */

public class MoneyDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "money.db";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME = "money";
    public static final String COL_ID = "_id";
    public static final String COL_DETAIL = "detail";
    public static final String COL_MONEY = "money";
    public static final String COL_PICTURE = "picture";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_PICTURE + " TEXT, "
            + COL_DETAIL + " TEXT, "
            + COL_MONEY + " TEXT) ";

    public MoneyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_PICTURE,"ic_income.png");
        cv.put(COL_DETAIL, "คุณพ่อให้เงิน");
        cv.put(COL_MONEY, "8000");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_PICTURE,"ic_expense.png");
        cv.put(COL_DETAIL, "จ่ายค่าหอ");
        cv.put(COL_MONEY, "2500");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_PICTURE,"ic_expense.png");
        cv.put(COL_DETAIL, "ซื้อล็อตเตอรี่ 1 ชุด");
        cv.put(COL_MONEY, "700");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_PICTURE,"ic_income.png");
        cv.put(COL_DETAIL, "ถูกล็อตเตอรี่รางวัลที่ 1");
        cv.put(COL_MONEY, "30000000");
        db.insert(TABLE_NAME, null, cv);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}