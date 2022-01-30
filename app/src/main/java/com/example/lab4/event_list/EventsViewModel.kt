package com.example.lab4.event_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class EventsViewModel: ViewModel() {

    private val events: MutableLiveData<List<EventReminder>> = MutableLiveData(listOf())

    fun getEvents(): LiveData<List<EventReminder>> {
        return events
    }

    init {
        events.value = loadMockEvents()
    }

    private fun loadMockEvents() = listOf(
        EventReminder(
            title = "Event 1",
            desc = "Description of event 1",
            dateStart = Calendar.getInstance().time
        ),
        EventReminder(
            title = "Event 2",
            desc = "Long description of event 2",
            dateStart = Calendar.getInstance().time
        ),
        EventReminder(
            title = "Event 3",
            desc = "Very very very very very very very very very very very very long description of event 3",
            dateStart = Calendar.getInstance().time
        ),
        EventReminder(
            title = "Event 4",
            desc = "Description of event 4",
            dateStart = Calendar.getInstance().time
        ),
        EventReminder(
            title = "Event 5",
            desc = "Description of event 5",
            dateStart = Calendar.getInstance().time
        ),
        EventReminder(
            title = "Event 6",
            desc = "Description of event 6",
            dateStart = Calendar.getInstance().time
        ),
        EventReminder(
            title = "Event 7",
            desc = "Description of event 7",
            dateStart = Calendar.getInstance().time
        ),
    )
}