package com.simplesmartapps.emmanuelpastor.todolist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.simplesmartapps.emmanuelpastor.todolist.data.Task
import com.simplesmartapps.emmanuelpastor.todolist.data.TaskRepository

class MyViewModel: ViewModel() {
    private val mRepository = TaskRepository()

    fun insertTask(task: Task) {
        mRepository.insertTask(task)
    }

    fun getAllTasks() = mRepository.getAllTasks()
}