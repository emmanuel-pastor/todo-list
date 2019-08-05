package com.simplesmartapps.emmanuelpastor.todolist.data

import android.util.Log
import com.simplesmartapps.emmanuelpastor.todolist.App
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TaskRepository {

    private val mTaskDao =  App.database.taskDao()

    fun insertTask(task: Task) {
        GlobalScope.launch { insertSuspend(task) }
    }
    private suspend fun insertSuspend(task: Task) {
        withContext(IO){
            mTaskDao.insertTask(task)
        }
    }

    fun getAllTasks() = mTaskDao.getAllTasks()
}