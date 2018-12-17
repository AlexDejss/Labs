package com.gmail.aleksmemby.currencylab2;

import android.content.Context
import android.database.Cursor
import android.util.Log
import java.util.*

/**
 * Created by Dejss on 07.11.2017.
 */
class TrainDBOperations(context: Context) {

    private val base: SQLBase = SQLBase(context)

    fun saveCurrency(info: ArrayList<Currency>){
        var sql = base.writableDatabase
        info.forEach {
            var title = it.name
            var price = it.rate
            val query = "INSERT or replace INTO CURRENCY_BY (title, price) VALUES('$title','$price')"
            sql.execSQL(query)
        }

    }

    fun readStorage(): ArrayList<Currency>{
        var sql = base.readableDatabase

        var list = ArrayList<Currency>()

        val query = "SELECT * FROM CURRENCY_BY"
        val cursor:Cursor = sql.rawQuery(query, Array<String>(0){""})

        if(cursor.moveToFirst()){
            do {

                var title = cursor.getString(cursor.getColumnIndex("title"))
                var price = cursor.getInt(cursor.getColumnIndex("price"))

                Log.v("SQL_proc_load_list", "Title - $title | Price - $price")

                list.add(Currency(0,"",0,title, price))

            }while(cursor.moveToNext())

        }
        cursor.close()
        return list
    }

}