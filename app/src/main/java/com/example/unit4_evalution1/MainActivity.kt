package com.example.unit4_evalution1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dataBaseHandler = DataBaseHandler(this )
        dataBaseHandler.insertDatabase("Masai School BootCamp", "Coding Contest","12oct", "Banglore", "25000")

    }
}