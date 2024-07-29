package com.example.tracker.task

import TaskViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskCard(modifier: Modifier = Modifier, taskViewModel: TaskViewModel) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = modifier.height(150.dp).fillMaxWidth().padding(all = 16.dp)) {
            Text(text = taskViewModel.task.title, style = MaterialTheme.typography.titleLarge)
            Text(text = taskViewModel.task.description)
            Text(text = "Time difference: ${taskViewModel.timeDifference} seconds")
        }
    }
}