package com.example.unit4_evalution1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var routineList: MutableList<EventModel> = mutableListOf()
    lateinit var mAdapter: EventAdapter
    lateinit var dataBaseHandler: DataBaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBaseHandler = DataBaseHandler(this )
        search_view.setOnClickListener {

                     routineList = dataBaseHandler.Nimit()
                     mAdapter = EventAdapter(this, routineList)
                     rvRecylerview.layoutManager = LinearLayoutManager(this)
                     rvRecylerview.adapter = mAdapter


        }
        dataBaseHandler.insertDatabase("Masai School BootCamp", "Coding Contest","12oct", "Banglore", "25000")
        dataBaseHandler.insertDatabase("Prestige School BootCamp", "Coding Contest","12oct", "Banglore", "25000")
       dataBaseHandler.insertDatabase("IPS School BootCamp", "Coding Contest","12oct", "Banglore", "25000")
       dataBaseHandler.insertDatabase("Delhi School BootCamp", "Coding Contest","12oct", "Banglore", "25000")
      dataBaseHandler.insertDatabase("Punjab School BootCamp", "Coding Contest","12oct", "Banglore", "25000")
        btnDelete.setOnClickListener {
            dataBaseHandler.delete(1)
            dataBaseHandler.delete(2)
          //  dataBaseHandler.delete(3)
          //  dataBaseHandler.delete(4)
          //  dataBaseHandler.delete(5)
        }
        btnUpdate.setOnClickListener {
            dataBaseHandler.update(1, "Prestige Collage", "Electronics Com","15oct", "Indore", "45000")
            dataBaseHandler.update(2, "Prestige Collage", "Electronics Com","15oct", "Indore", "45000")
        }


    }
}