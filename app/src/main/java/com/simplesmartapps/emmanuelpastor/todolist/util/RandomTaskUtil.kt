package com.simplesmartapps.emmanuelpastor.todolist.util

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import com.simplesmartapps.emmanuelpastor.todolist.data.Task
import java.util.*

object RandomTaskUtil {

    fun getRandomTask(): Task {
        val title = getRandomTitle()
        val content = getRandomContent()
        return Task(title, content, Date())
    }

    private fun getRandomTitle() = getRandomString(6)

    private fun getRandomContent(): String {
        var output = ""

        for (i in 1..2) {
            output += "${getRandomString(12)}\n"
        }
        output += getRandomString(12)

        return output
    }

    private fun getRandomString(stringLength: Long): String {
        val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        return java.util.Random().ints(stringLength, 0, source.length)
            .toArray()
            .map(source::get)
            .joinToString("")
    }
}