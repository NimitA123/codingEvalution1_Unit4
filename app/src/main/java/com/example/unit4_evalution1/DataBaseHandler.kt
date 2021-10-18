package com.example.unit4_evalution1

import android.content.ContentProvider
import android.content.ContentProviderClient
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DataBaseHandler(val context: Context): SQLiteOpenHelper(context, "Journalbd", null, 1) {
    companion object{
        val TABLE_Name = "Journal"
        val Id = "id"
        val Event_Name = "event_name"

        val Event_desc = "event_desc"
        val Event_date = "event_date"
        val Event_Location = "event_location"
        val Event_Price = "Event_price"
    }
    override fun onCreate(p0: SQLiteDatabase?) {
        val Create_Query = "CREATE TABLE $TABLE_Name($Id INTEGER PRIMARY KEY, $Event_Name TEXT, $Event_desc TEXT, $Event_date TEXT, $Event_Location TEXT, $Event_Price TEXT)"
        p0?.execSQL(Create_Query)



    }
    fun insertDatabase(event_name:String, event_desc:String, event_date:String, event_location:String, event_price:String){
        val db = writableDatabase
        val value = ContentValues()
        value.put(Event_Name, event_name)
        value.put(Event_desc, event_desc)
        value.put(Event_date, event_date)
        value.put(Event_Location, event_location)
        value.put(Event_Price, event_price)
        val id = db.insert(TABLE_Name, null, value)
        if(id.toInt()== -1){
            Toast.makeText(context, "Data not insert SuccussFully", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context, "Data  insert SuccussFully", Toast.LENGTH_LONG).show()
        }


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}