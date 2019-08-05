package com.simplesmartapps.emmanuelpastor.todolist

import android.app.Application
import androidx.room.Room
import com.simplesmartapps.emmanuelpastor.todolist.data.ToDoDatabase
import java.util.concurrent.TimeUnit

class App : Application() {

    companion object {
        lateinit var database: ToDoDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, ToDoDatabase::class.java, "todo_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}