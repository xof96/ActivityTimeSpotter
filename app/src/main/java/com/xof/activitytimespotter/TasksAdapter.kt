package com.xof.activitytimespotter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_card_view.view.*

class TasksAdapter(private val tasks: List<Task>) :
    RecyclerView.Adapter<TasksAdapter.MyViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(task: Task?, pos: Int) {
            itemView.task_name.text = task!!.name
            itemView.task_time.text = task.time
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TasksAdapter.MyViewHolder {
        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_card_view, parent, false) as View
        // set the view's size, margins, paddings and layout parameters
//        ...
        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val task = tasks[position]
        holder.setData(task, position)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = tasks.size
}