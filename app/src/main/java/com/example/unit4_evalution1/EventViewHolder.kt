package com.example.unit4_evalution1

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textview:TextView = itemView.findViewById(R.id.textView)
    var textview1:TextView = itemView.findViewById(R.id.textView2)
    var textview2:TextView = itemView.findViewById(R.id.textView3)
    var textview3:TextView = itemView.findViewById(R.id.textView4)
    var textview4:TextView = itemView.findViewById(R.id.textView5)
    fun setdata(eventModel: EventModel){
        textview.setText(eventModel.event_name)
        textview1.setText(eventModel.event_des)
        textview2.setText(eventModel.event_date)
        textview3.setText(eventModel.event_location)
        textview4.setText(eventModel.event_price)
    }
}
