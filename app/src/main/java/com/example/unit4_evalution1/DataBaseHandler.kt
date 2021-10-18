package com.example.unit4_evalution1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
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
    fun Nimit() : MutableList<EventModel> {
        val listRountain : MutableList<EventModel> = mutableListOf<EventModel>()
        val db  = readableDatabase
        val query  = "SELECT * FROM $TABLE_Name"
        val cursor: Cursor = db.rawQuery(query, null)
        if(cursor!=null && cursor.count>0){
            cursor.moveToFirst()
            do{
                val idIndex = cursor.getColumnIndex(Id)
                val Question = cursor.getColumnIndex(Event_Name)
                val OptionA = cursor.getColumnIndex(Event_desc)
                val OptionB = cursor.getColumnIndex(Event_date)
                val OptionC = cursor.getColumnIndex(Event_Location)
                val OptionD = cursor.getColumnIndex(Event_Location)
                val id = cursor.getInt(idIndex)
                val question = cursor.getString(Question)
                val optionA = cursor.getString(OptionA)
                val optionB = cursor.getString(OptionB)
                val optionC = cursor.getString(OptionC)
                val optionD = cursor.getString(OptionD)
                val routainModel = EventModel(id, question, optionA, optionB, optionC, optionD)
                listRountain.add(routainModel)
            }
            while(cursor.moveToNext())


        }


        //curson is a class which will return row and column and also some other method
        return listRountain
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}