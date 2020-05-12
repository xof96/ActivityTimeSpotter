package com.xof.activitytimespotter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xof.activitytimespotter.R
import com.xof.activitytimespotter.Supplier
import com.xof.activitytimespotter.TasksAdapter

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()

    private lateinit var recyclerViewYesterday: RecyclerView
    private lateinit var viewAdapterYesterday: RecyclerView.Adapter<*>
    private lateinit var viewManagerYesterday: RecyclerView.LayoutManager
    private lateinit var recyclerViewToday: RecyclerView
    private lateinit var viewAdapterToday: RecyclerView.Adapter<*>
    private lateinit var viewManagerToday: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val yesterdayDateTextView: TextView = root.findViewById(R.id.yesterday_date_text)
        homeViewModel.yesterdayDateText.observe(viewLifecycleOwner, Observer {
            yesterdayDateTextView.text = it
        })

        viewManagerYesterday = LinearLayoutManager(activity)
        viewAdapterYesterday = TasksAdapter(Supplier.yesterday_tasks)
        recyclerViewYesterday = root.findViewById<RecyclerView>(R.id.yesterday_tasks_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            isFocusable = false
            // use a linear layout manager
            layoutManager = viewManagerYesterday
            // specify an viewAdapter (see also next example)
            adapter = viewAdapterYesterday
        }

        val todayDateTextView: TextView = root.findViewById(R.id.today_date_text)
        homeViewModel.todayDateText.observe(viewLifecycleOwner, Observer {
            todayDateTextView.text = it
        })

        viewManagerToday = LinearLayoutManager(activity)
        viewAdapterToday = TasksAdapter(Supplier.today_tasks)
        recyclerViewToday = root.findViewById<RecyclerView>(R.id.today_tasks_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)
            isFocusable = false
            // use a linear layout manager
            layoutManager = viewManagerToday
            // specify an viewAdapter (see also next example)
            adapter = viewAdapterToday
        }

        return root
    }
}
