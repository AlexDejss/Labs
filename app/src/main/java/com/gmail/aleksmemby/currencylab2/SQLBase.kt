package com.gmail.aleksmemby.currencylab2;

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Dejss on 07.11.2017.
 */
class SQLBase(context: Context) : SQLiteOpenHelper(context, "currency_by", null, 2) {
    override fun onCreate(sql: SQLiteDatabase) {
        sql.execSQL("create table if not exists CURRENCY_BY (title text primary key, price integer);")
    }

    override fun onUpgrade(sql: SQLiteDatabase, old_v: Int, new_v: Int) {

    }

}