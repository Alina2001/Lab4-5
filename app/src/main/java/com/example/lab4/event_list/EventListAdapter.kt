package com.example.lab4.event_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.R
import java.text.SimpleDateFormat
import java.util.*

class EventListAdapter : RecyclerView.Adapter<EventListAdapter.ViewHolder>(){

    private val values: MutableList<EventReminder> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.event_reminder_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount() = values.size

    fun setData(newValues: List<EventReminder>) {
        values.clear()
        values.addAll(newValues)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleTV: TextView = view.findViewById(R.id.event_title)
        private val descriptionTV: TextView = view.findViewById(R.id.event_description)
        private val dateTV: TextView = view.findViewById(R.id.event_date)

        private val formatter = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

        fun bind(data: EventReminder) {
            with(data) {
                titleTV.text = title
                descriptionTV.text = desc
                dateTV.text = formatter.format(dateStart)
            }
        }
    }
}