package com.simplesmartapps.emmanuelpastor.todolist

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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

            if (it.isEmpty()) {
                no_tasks_layout.visibility = View.VISIBLE
            } else {
                no_tasks_layout.visibility = View.GONE
            }
        })

        add_task_button.setOnClickListener {
            mViewModel.insertTask(RandomTaskUtil.getRandomTask())
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.clear_menu_item) {
            mViewModel.deleteAll()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
