package com.xof.activitytimespotter.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.xof.activitytimespotter.R

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()

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

        val todayDateTextView: TextView = root.findViewById(R.id.today_date_text)
        homeViewModel.todayDateText.observe(viewLifecycleOwner, Observer {
            todayDateTextView.text = it
        })

//        val cardView: CardView = CardView()
        return root
    }
}
