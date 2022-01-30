package com.example.lab4.event_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.R

class EventsFragment : Fragment() {

    private val eventListAdapter = EventListAdapter()

    private val viewModel: EventsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.events_rv)
        with(recyclerView) {
            adapter = eventListAdapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.getEvents().observe(viewLifecycleOwner) {
            eventListAdapter.setData(it)
        }
    }
}