package com.simplesmartapps.emmanuelpastor.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simplesmartapps.emmanuelpastor.todolist.data.Task
import com.simplesmartapps.emmanuelpastor.todolist.data.TaskRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {
    private val mRepository = TaskRepository()

    fun insertTask(task: Task) {
        mRepository.insertTask(task)
    }

    fun getAllTasks() = mRepository.getAllTasks()

    fun deleteAll() = viewModelScope.launch {
        withContext(IO) {
            mRepository.deleteAll()
        }
    }
}