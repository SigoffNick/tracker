package com.example.tracker.main_screen

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.tracker.task.Task
import java.time.LocalDateTime

class MainScreenViewModel : ViewModel() {
    private val _tasks =
        mutableListOf(
            Task(
                title = "1",
                description = "1 task description",
                time = LocalDateTime.now()
            ),
            Task(
                title = "2",
                description = "2 task description",
                time = LocalDateTime.now()
            ),
            Task(
                title = "3",
                description = "3 task description",
                time = LocalDateTime.now()
            ),
            Task(
                title = "4",
                description = "4 task description",
                time = LocalDateTime.now()
            )
        ).toMutableStateList()

    fun getTasks(): List<Task> {
        return _tasks
    }

    fun addTask(task: Task): Unit {
        _tasks.add(task)
    }

    fun addDefaultTask() {
        _tasks.add(Task(title = "Title", description = "", time = LocalDateTime.now()))
    }

    fun removeTask(index: Int) {
        _tasks.removeAt(index)
    }
}