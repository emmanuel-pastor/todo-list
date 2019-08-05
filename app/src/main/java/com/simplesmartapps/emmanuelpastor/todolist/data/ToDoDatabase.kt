package com.simplesmartapps.emmanuelpastor.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Task::class], version = 4, exportSchema = false )

@TypeConverters(Converters::class)

abstract class ToDoDatabase : RoomDatabase() {

    // fonction abstraite qui pourra créé un taskDao
    abstract fun taskDao() : TaskDao
}