package com.example.unit4_evalution1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(
    val context: Context,
    val routineList: MutableList<EventModel>,
): RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
       val menu = routineList.get(position)
        holder.setdata(menu)
    }

    override fun getItemCount(): Int {
       return routineList.size
    }
}