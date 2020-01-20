package com.simplesmartapps.emmanuelpastor.todolist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.simplesmartapps.emmanuelpastor.todolist.data.Task
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.*

class TaskAdapter() :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    var mTasks: List<Task>? = null

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.task_title
        val content: TextView = itemView.task_content
        val date: TextView = itemView.task_date
        val id: TextView = itemView.task_id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewItem = inflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (mTasks != null) {
            val currentTask = mTasks!![position]

            holder.title.text = currentTask.title
            holder.content.text = currentTask.content

            val taskDate = currentTask.date
            val formattedTaskDate =
                java.text.SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(taskDate)
            holder.date.text = formattedTaskDate

            holder.id.text = currentTask.id.toString()
        }
    }

    override fun getItemCount(): Int {
        return if (mTasks != null) {
            mTasks!!.size
        } else 0
    }

    fun updateList(tasks: List<Task>?) {
        mTasks = tasks
        notifyDataSetChanged()
    }
}