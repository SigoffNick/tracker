@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.tracker.main_screen

import TaskViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tracker.TopLevelDestination
import com.example.tracker.task.TaskCard


object ReplyRoute {
    const val HOME = "Home"
    const val NOTIFICATIONS = "Notification"
    const val PROFILE = "Profile"
}

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = ReplyRoute.HOME,
        icon = Icons.Default.Home,
        description = "Home",
    ),
    TopLevelDestination(
        route = ReplyRoute.NOTIFICATIONS,
        icon = Icons.Default.Notifications,
        description = "Notification",
    ),
    TopLevelDestination(
        route = ReplyRoute.PROFILE,
        icon = Icons.Default.Person,
        description = "Profile",
    ),
)

@Composable
fun MainScreen(
    modifier: Modifier = Modifier, viewModel: MainScreenViewModel = MainScreenViewModel()
) {
    val selectedDestination = remember { mutableStateOf(ReplyRoute.HOME) }
    Scaffold(topBar = {
        TopAppBar(title = { Text("My App Title") })
    },
        floatingActionButton = {
            LargeFloatingActionButton(onClick = {
                viewModel.addDefaultTask()
            }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        bottomBar = {
            NavigationBar(modifier = Modifier.fillMaxWidth()) {
                TOP_LEVEL_DESTINATIONS.forEach { destination ->
                    NavigationBarItem(
                        selected = selectedDestination.value == destination.route,
                        onClick = {
                            selectedDestination.value = destination.route
                        },
                        icon = {
                            Icon(
                                imageVector = destination.icon,
                                contentDescription = destination.description
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.padding(innerPadding)
        ) {
            items(viewModel.getTasks().size) { index ->
                val tskViewModel = TaskViewModel(viewModel.getTasks()[index])
                TaskCard(taskViewModel = tskViewModel)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}