package com.simplesmartapps.emmanuelpastor.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.simplesmartapps.emmanuelpastor.todolist.data.Task
import com.simplesmartapps.emmanuelpastor.todolist.util.RandomTaskUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = recycler_view
        val adapter = TaskAdapter()

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        mViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        mViewModel.getAllTasks().observe(this, Observer {
            adapter.updateList(it)
        })

        add_task_button.setOnClickListener {
            mViewModel.insertTask(RandomTaskUtil.getRandomTask())
        }

    }
}
