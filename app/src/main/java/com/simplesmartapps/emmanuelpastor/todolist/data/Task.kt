package com.simplesmartapps.emmanuelpastor.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "tasks"
)
data class Task(var title: String, var content: String, var date: Date) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return "Title : $title\nContent : $content\nDate : ${date.time}\nID : $id"
    }
}