package com.simplesmartapps.emmanuelpastor.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.simplesmartapps.emmanuelpastor.todolist.util.RandomTaskUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = recycler_view
        val adapter = TaskAdapter()

        recyclerView.adapter = adapter

        mViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        mViewModel.getAllTasks().observe(this, Observer {
            adapter.updateList(it)
        })

        add_task_button.setOnClickListener {
            mViewModel.insertTask(RandomTaskUtil.getRandomTask())
        }

    }
}
